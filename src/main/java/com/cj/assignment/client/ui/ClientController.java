package com.cj.assignment.client.ui;

import static com.cj.assignment.client.ui.ClientResponseMessage.FIND_CLIENT_SUCESS;
import static com.cj.assignment.client.ui.ClientResponseMessage.SAVE_CLIENT_SUCCESS;

import com.cj.assignment.client.application.ClientService;
import com.cj.assignment.client.dto.ClientFindResponse;
import com.cj.assignment.client.dto.ClientSaveRequest;
import com.cj.assignment.common.dto.CommonResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ApiOperation(value = "고객 정보 저장 API")
    public CommonResponse<Void> saveClient(@Valid @RequestBody ClientSaveRequest request) {
        clientService.saveClient(request);
        return CommonResponse.from(SAVE_CLIENT_SUCCESS.getMessage());
    }

    @GetMapping("/{clientId}")
    @ApiOperation(value = "고객 정보 조회 API")
    public CommonResponse<ClientFindResponse> findClient(@PathVariable Long clientId) {
        return CommonResponse.of(clientService.findClient(clientId), FIND_CLIENT_SUCESS.getMessage());
    }

}
