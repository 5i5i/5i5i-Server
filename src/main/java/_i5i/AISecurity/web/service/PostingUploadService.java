package _i5i.AISecurity.web.service;

import _i5i.AISecurity.apiPayload.code.status.ErrorStatus;
import _i5i.AISecurity.web.domain.member.entity.Member;
import _i5i.AISecurity.web.domain.member.repository.MemberRepository;
import _i5i.AISecurity.web.domain.posting.converter.PostingConverter;
import _i5i.AISecurity.web.domain.posting.dto.PostingRequestDTO;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
import _i5i.AISecurity.web.domain.posting.repository.PostingRepository;
import _i5i.AISecurity.web.handler.MemberHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PostingUploadService {
    private final PostingRepository postingRepository;
    private final MemberRepository memberRepository;

    public Posting createPosting(PostingRequestDTO.PostingUploadRequestDTO dto, Long memberId){
        Member member=memberRepository.findById(memberId)
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Posting posting= PostingConverter.toEntity(dto,member);
        return postingRepository.save(posting);
    }
}
