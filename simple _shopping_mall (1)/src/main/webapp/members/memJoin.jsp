<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style type="text/css">
	*{
		font-size: 10pt;
	}
</style>
</head>
<body>
	<div align="center">
		<form action="">
			<table border="1">
					<colgroup>
						<col width="100px">
						<col width="320px">
						<col width="160px">
					</colgroup>
	
				<thead>
					<tr style="text-align: center;">
						<td colspan="3">회원 가입</td>
					</tr>
				</thead>
					
				<tbody>
					<tr>
						<td>아이디</td>
						<td>
							<input type="text" name="id">
							<input type="button" value="ID중복확인">
						</td>
						<td>아이디를 적어 주세요.</td>
					</tr>
					
					<tr>
						<td>패스워드</td>
						<td>
							<input type="password" value="">
						</td>
						<td>패스워드를 적어주세요.</td>
					</tr>
					
					<tr>
						<td>패스워드 확인</td>
						<td>
							<input type="password" value="">
						</td>
						<td>패스워드를 확인합니다.</td>
					</tr>
					
					<tr>
						<td>이름</td>
						<td>
							<input type="text" value="">
						</td>
						<td>고객실명을 적어주세요.</td>
					</tr>
					
					<tr>
						<td>성별</td>
						<td>
							<input type="radio" name="chk_s" value="men" checked="checked">남자
							<input type="radio" name="chk_s" value="women" >여자
						</td>
						<td>성별을 선택하세요.</td>
					</tr>
					
					<tr>
						<td>생년월일</td>
						<td>
							<input type="text" maxlength="6" name="" style="width: 70px;">&nbsp;ex&#41;830815
						</td>
						<td>성별을 선택하세요.</td>
					</tr>
					
					<tr>
						<td>이메일</td>
						<td>
							<input type="email" name="email">
						</td>
						<td>이메일을 적어주세요.</td>
					</tr>
					
					<tr>
						<td>우편번호</td>
						<td>
							<input type="text"  name="" style="width: 40px;" >
							<input type="button" value="우편번호찾기" onclick="">
						</td>
						<td>우편번호를 검색하세요.</td>
					</tr>
					
					<tr>
						<td>주소</td>
						<td>
							<input type="text" name="adrr" style="width: 280px;">
						</td>
						<td>주소를 적어주세요.</td>
					</tr>
					
					<tr>
						<td>직업</td>
						<td>
							<select>
								<option selected="selected">선택하세요.</option>
								<option>회사원</option>
								<option>연구전문직</option>
								<option>교수학생</option>
								<option>일반자영업</option>
								<option>의료인</option>
								<option>법조인</option>
								<option>종교,언론/예술인</option>
								<option>농/축/수산/광업인</option>
								<option>주부</option>
								<option>무직</option>
								<option>기타</option>
							</select>					
						</td>
						<td>직업을 선택하세요.</td>
					</tr>
					
					<tr>
						<td>취미</td>
						<td>
							<input type="checkbox">인터넷
							<input type="checkbox">여행
							<input type="checkbox">게임
							<input type="checkbox">영화
							<input type="checkbox">운동
						</td>
						<td>취미를 선택하세요.</td>
					</tr>
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="3" style="text-align: center;">
							<input type="submit" value="회원가입" style="margin-right: 60px;" />
							<input type="reset" value="다시쓰기" />
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>