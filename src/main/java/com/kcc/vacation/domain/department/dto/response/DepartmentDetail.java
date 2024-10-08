package com.kcc.vacation.domain.department.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
public class DepartmentDetail {

    @Setter
    private int id;
    private String name;
    private int upperDeptId;
    private int level;

    @Builder
    public DepartmentDetail(int id, String name, int upperDeptId, int level) {
        this.id = id;
        this.name = name;
        this.upperDeptId = upperDeptId;
        this.level = level;
    }
}
