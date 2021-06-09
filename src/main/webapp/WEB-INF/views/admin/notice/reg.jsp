<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
				<main id="main">
					<section class="notice">
						<h1 class="main-title">공지사항</h1>
						<section class="breadcrumb mt-3">
							<h1 class="d-none">경로</h1>
							<ol>
								<li>home</li>
								<li>고객센터</li>
								<li>공지사항</li>
							</ol>
						</section>
						<form class="form" action="reg" method="POST" enctype="multipart/form-data">
							<table border="1">
								<tr>
									<th>제목</th>
									<td colspan="3"><input type="text" name="title" value="" /></td>
								</tr>
								<tr>
									<th>첨부파일</th>
									<td colspan="3"><input type="file" name="file" accept="image/png, image/png, image/jpeg" multiple="multiple"/></td>
								</tr>
								<tr>
									<th>첨부파일</th>
									<td colspan="3"><input type="file" name="file" /></td>
								</tr>
								<tr>
									<td colspan="4">
									<div contenteditable="true"></div>
									<textarea name="content" rows="20"cols="40"></textarea>
                              		</td>
								</tr>
							</table>
							<div class="progress-status">
								<div><span class="bar">0%</span></div>
								<progress id="fileStatus" max="100" value="0"> </progress>
								<ul>
								</ul>
							</div>
							<section id="dnd-section">
								<style>
#dnd-section .upload-box {
	width: 500px;
	height: 150px;
	border: 1px solid gray;
	box-shadow: 2px 3px 9px #797979;
	padding: 10px;
}
#dnd-section .upload-box.valid {
	background: green;
}

#dnd-section .upload-box.invalid {
	background: red;
}

.drag-on {
	border: 2px solid orange !important;
}

.progress-status {
	font-size: 20px;
	width: 600px;
}

.progress-status .bar {
	display: inline-block;
	height: 20px;
	width: 0%;
	background-color: #0075FF;
	text-align: right;
	color: #fff;
}
</style>
								<h1>파일업로드 : DND & Trigger</h1>
								<div class="upload-box">
									<button class="btn-sel">파일선택</button>
									<input type="file" name="file" id="file"
										class="btn-file d-none">
								</div>
							</section>
							<div>
								<input type="submit" value="저장"> <a href="list.jsp">취소</a>
							</div>
						</form>
					</section>
				</main>
