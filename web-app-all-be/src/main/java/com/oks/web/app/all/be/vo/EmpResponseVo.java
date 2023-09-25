package com.oks.web.app.all.be.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "serviceResponse")
public class EmpResponseVo {
	private String message;
	private String status;
	private List<EmpVo> empVo;
}
