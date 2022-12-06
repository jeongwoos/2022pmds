package com.cj.assignment.client.application;

import com.cj.assignment.client.domain.ClientRepository;
import com.cj.assignment.client.dto.ClientFindResponse;
import com.cj.assignment.client.dto.ClientSaveRequest;
import com.cj.assignment.client.exception.NotExistClientException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void saveClient(ClientSaveRequest request){
        clientRepository.save(request.toClient());
    }

    public ClientFindResponse findClient(Long clientId) {
        return ClientFindResponse.from(
                clientRepository.findById(clientId).orElseThrow(NotExistClientException::new)
        );
    }
}
