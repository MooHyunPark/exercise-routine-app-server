package com.metacoding.exerciseappserver.user;

import com.metacoding.exerciseappserver._core.auth.SessionUser;
import com.metacoding.exerciseappserver._core.error.exception.Exception403;
import com.metacoding.exerciseappserver._core.util.ApiUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/init/download")
    public ResponseEntity<?> initDownload() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(ApiUtil.success(null));
    }

    /**
     * 클라이언트가 JWT가 존재하면 Authorization에 JWT를 담아서 POST요청
     * JWT 검증이 완료되면, 사용자 정보 응답
     * 클라이언트는 사용자 정보로 세션 만들고, 자동 로그인 처리
     *
     * JWT 검증 실패 (JWT_NOT_FOUND, JWT_INVALID, JWT_TIMEOUT)
     */
    @PostMapping("/auto/login")
    public ResponseEntity<?> autoLogin(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization");
        UserResponse.AutoLoginDTO responseDTO = userService.자동로그인(accessToken);
        return ResponseEntity.ok(ApiUtil.success(responseDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest.LoginDTO requestDTO) {
        UserResponse.LoginDTO responseDTO = userService.로그인(requestDTO);
        return ResponseEntity.ok()
                .header("Authorization", responseDTO.accessToken())
                .body(ApiUtil.success(responseDTO));
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserRequest.JoinDTO requestDTO) {
        System.out.println(requestDTO.toString());
        return ResponseEntity.ok(ApiUtil.success(userService.회원가입(requestDTO)));
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<?> userinfo(@PathVariable Integer id, @SessionUser User sessionUser) {
        System.out.println("sessionUser : id : "+sessionUser.getId());
        if (sessionUser.getId() != id) {
            throw new Exception403("해당 정보에 접근할 권한이 없습니다 : "+id);
        }
        return ResponseEntity.ok(ApiUtil.success(userService.회원정보보기(id)));
    }

    @PutMapping("/api/user/{id}/password")
    public ResponseEntity<?> userPasswordUpdate(@PathVariable Integer id, @RequestBody UserRequest.PasswordUpdateDTO requestDTO, @SessionUser User sessionUser) {
        if (sessionUser.getId() != id) {
            throw new Exception403("해당 정보를 수정할 권한이 없습니다 : "+id);
        }
        userService.패스워드수정(id, requestDTO);
        return ResponseEntity.ok(ApiUtil.success(null));
    }

    @PutMapping("/api/user/update")
    public ResponseEntity<?> updateUserInfo(@RequestBody UserRequest.UserInfoUpdateDTO requestDTO, @SessionUser User sessionUser) {
        System.out.println("updateUserInfo 실행");
        UserResponse.UpdateInfoDTO updateInfoDTO= userService.회원정보수정(sessionUser.getId(),requestDTO);
        return ResponseEntity.ok(ApiUtil.success(updateInfoDTO));
    }

}
