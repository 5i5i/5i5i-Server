package _i5i.AISecurity.web.service;

import _i5i.AISecurity.apiPayload.code.status.ErrorStatus;
import _i5i.AISecurity.web.domain.leaked_information.entity.LeakedInformation;
import _i5i.AISecurity.web.domain.leaked_information.repository.LeakedInformationRepository;
import _i5i.AISecurity.web.domain.location.entity.Location;
import _i5i.AISecurity.web.domain.location.repository.LocationRepository;
import _i5i.AISecurity.web.domain.member.entity.Member;
import _i5i.AISecurity.web.domain.member.repository.MemberRepository;
import _i5i.AISecurity.web.domain.posting.converter.PostingConverter;
import _i5i.AISecurity.web.domain.posting.dto.PostingRequestDTO;
import _i5i.AISecurity.web.domain.posting.dto.PostingResponseDTO;
import _i5i.AISecurity.web.domain.posting.entity.Posting;
import _i5i.AISecurity.web.domain.posting.repository.PostingRepository;
import _i5i.AISecurity.web.handler.MemberHandler;
import _i5i.AISecurity.web.handler.PostingHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;
    private final MemberRepository memberRepository;
    private final LeakedInformationRepository leakedInfRepository;
    private final LocationRepository locationRepository;

    public Page<Posting> getPostingList(Long memberId, Integer page){
        Member member=memberRepository.findById(memberId)
                .orElseThrow(()->new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        return postingRepository.findAllByMember(member, PageRequest.of(page,8));
    }

    public Posting createPosting(PostingRequestDTO.PostingUploadRequestDTO dto, Long postingId){
        Posting posting=postingRepository.findById(postingId)
                .orElseThrow(()->new PostingHandler(ErrorStatus.POSTING_NOT_FOUND));
        posting.updateContent(dto.getContent(), dto.getTitle());
        return postingRepository.save(posting);
    }

    public PostingResponseDTO.postingcontentDTO getPosting(Long postingId){
        Posting posting=postingRepository.findById(postingId)
                .orElseThrow(()->new PostingHandler(ErrorStatus.POSTING_NOT_FOUND));
        return PostingConverter.toPostingcontentDTO(posting,posting.getMember().getName());
    }

    public PostingResponseDTO.resultDTO updatePosting(Long postingId, PostingRequestDTO.PostingUploadRequestDTO dto){
        Posting posting = postingRepository.findById(postingId)
                .orElseThrow(() -> new PostingHandler(ErrorStatus.POSTING_NOT_FOUND));

        posting.updateContent(dto.getContent(), dto.getTitle());

        postingRepository.save(posting);

        return PostingConverter.toResultDTO(posting);
    }

    public PostingResponseDTO.infResultDTO getInfResult(Long postingId){
        Posting posting = postingRepository.findById(postingId)
                .orElseThrow(() -> new PostingHandler(ErrorStatus.POSTING_NOT_FOUND));

        List<LeakedInformation> leakedInfs=leakedInfRepository.findAllByPosting(posting);
        List<Location> locations=locationRepository.findAllByPosting(posting);

        return PostingConverter.toInfResultDTO(locations,leakedInfs);
    }
}

