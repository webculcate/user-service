package com.webculcate.userserviceclient.service;

import com.webculcate.userserviceclient.model.UserBulkRequest;
import com.webculcate.userserviceclient.model.UserBulkResponse;
import com.webculcate.userserviceclient.model.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static com.webculcate.userserviceclient.constant.UserServiceConstant.USER_SERVICE_NAME;

@FeignClient(name = USER_SERVICE_NAME)
public interface UserServiceClient {

    @GetMapping("/user/v1/{id}")
    ResponseEntity<UserDto> getUser(@PathVariable("id") Long id);

    @GetMapping("/user/v1/bulk")
    ResponseEntity<UserBulkResponse> getUserBulk(@RequestBody UserBulkRequest request);

}
