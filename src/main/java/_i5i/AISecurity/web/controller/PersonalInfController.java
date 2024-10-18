package _i5i.AISecurity.web.controller;

import _i5i.AISecurity.apiPayload.ApiResponse;
import _i5i.AISecurity.web.domain.personal_information.converter.PersonalInfConverter;
import _i5i.AISecurity.web.domain.personal_information.dto.PersonalInfRequestDTO;
import _i5i.AISecurity.web.domain.personal_information.dto.PersonalInfResponseDTO;
import _i5i.AISecurity.web.domain.personal_information.entity.PersonalInformation;
import _i5i.AISecurity.web.service.PersonalInfService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonalInfController {

    private final PersonalInfService personalInfService;

    @PostMapping("/{memberId}/information_write")
    @Operation(summary = "사용자 개인정보 입력 API",description = "사용자의 개인정보를 입력하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK, 성공"),
    }) public ApiResponse<PersonalInfResponseDTO.resultDTO> createPersonalInf(@PathVariable Long memberId, @RequestBody PersonalInfRequestDTO.PersonalInfDTO dto){
        PersonalInformation personalInformation=personalInfService.createPersonalInf(dto,memberId);
        return ApiResponse.onSuccess(PersonalInfConverter.toResultDTO(personalInformation));
    }
}
