package com.kcc.vacation.domain.vacationrequest.mapper;

import com.kcc.vacation.domain.vacationrequest.dto.request.MyVacationApprover;
import com.kcc.vacation.domain.vacationrequest.dto.request.MyVacationRequest;
import com.kcc.vacation.domain.vacationrequest.dto.response.*;
import com.kcc.vacation.domain.vacationrequest.dto.response.MyVacation;
import com.kcc.vacation.domain.vacationrequest.dto.response.VacationRequestDetail;
import com.kcc.vacation.domain.vacationrequest.dto.response.VacationRequestListDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VacationRequestMapper {

    // 관리자용 휴가 신청 자세히 보기
    VacationRequestDetail getVacationRequestDetail(int vacationRequestId);
    // 관리자용 휴가 신청 목록 보기
    List<VacationRequestListDetail> getVacationRequestListByApproverId(int approverId);
    // 관리자용 승인 버튼 눌렀을 때
    int approveVacation(int requestId, int approverId);
    // 최종 관리자 승인일 때
    int finalApproveVacation(int requestId);
    // 1. 관리자용 반려 버튼 눌렀을 때
    // 1-1. approver 테이블에 false 넣기
    int rejectVacationFALSE(int requestId, int approverId);
    // 1-2. vacation_request 테이블에 상태값 '거절' 과 comments 적기
    int rejectVacationSTATUS(int requestId, String commentsOfApprover);

    List<MyVacation> getMyVacations(int employeeId);
    int insertVacationRequest(MyVacationRequest myVacationRequest);

    int insertApprover(MyVacationApprover myVacationApprover);

    List<Approver> getMyApprover(int myDeptId);

    List<Approver> getByAuthority(String authority);

    List<VacationRequestListDetail> getClientReqList(int employeeId);

    List<VacationReqNCancelAll> getClientReqAllList();
}
