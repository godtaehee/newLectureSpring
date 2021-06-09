<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%-- <%@page import="com.newlecture.web.service.MemberService"%>
<%@page import="com.newlecture.web.entity.Member"%>
<%@page import="com.newlecture.web.service.NoticeService"%>
<%@page import="com.newlecture.web.entity.Notice"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
		<section class="search-form">
			<h1>검색폼</h1>
			<form action="list" method="GET">
				<label class="d-none">검색분류</label> <select name="category">
					<option value="">분류선택</option>
					<option ${param.category == 'title' ? 'selected' : '' }
						value="title">제목</option>
					<option ${param.category == 'writer_id' ? 'selected' : '' }
						value="writer_id">작성자</option>
				</select> <label class="d-none">검색어</label> <input type="text" name="keyword"
					value="${param.keyword }"> <input type="submit" value="검색">
			</form>
		</section>
		<section class="mt-3">
			<h1 class="d-none">공지사항 목록</h1>
			<table class="table notice-table">
				<thead>
					<tr>
						<td class="w-1">번호</td>
						<td class="truncate text-align-center">제목</td>
						<td class="w-2">작성자</td>
						<td class="w-2">작성일</td>
						<td class="w-1">조회수</td>
					</tr>
				</thead>
				<tbody>
					<%-- <% for(Map<String, Object> row : noticeList) {%> --%>
					<c:forEach var="noticeList" items="${noticeList}" varStatus="idx"
						begin="0" end="${noticeList.size() }">
						<tr>
							<td class="w-1">${noticeList.id }</td>
							<td class="truncate text-align-left"><a
								href="detail?id=${noticeList.id }">${noticeList.title }[20]</a>
							</td>
							<td class="w-2">${noticeList.writerId }</td>
							<td class="w-2"><fmt:formatDate
									value="${noticeList.regDate }" pattern="yyyy년 MM월 dd일" /></td>
							<td class="w-1">${noticeList.hit }</td>
						</tr>
					</c:forEach>
					<!-- <tr>
                      <td>1023</td>
                      <td class="truncate text-align-left">
                        스프링 JSON 출력을 위한 라이브러리 설정
                        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                      </td>
                      <td>newlec</td>
                      <td>2020-11-29</td>
                      <td>994</td>
                    </tr>
                    <tr>
                      <td>1022</td>
                      <td class="truncate text-align-left">
                        스프링 강좌 <kbd>Ctrl</kbd>+<kbd>Shift</kbd>
                        RestController 한글 깨짐 설정 코드
                      </td>
                      <td>newlec</td>
                      <td>2020-11-25</td>
                      <td>802</td>
                    </tr> -->
				</tbody>
			</table>
			<div>
				<a href="reg?id=${noticeList.id }">글쓰기</a>
			</div>
		</section>

		<section class="page-status mt-3">
			<h1 class="d-none">현재 페이지 정보</h1>
			<div>
				<c:set var="lastPage" value="${count/10 + (count%10==0?0:1) }" />
				<span class="text-strong">${(empty param.p) ? 1 : param.p}</span> /
				${fn:substringBefore(lastPages, '.')} pages
			</div>
		</section>
		<nav class="pager-nav mt-3">
			<h1 class="d-none">페이저</h1>
			<div class="pager-prev">이전</div>
			<ul class="pages">
				<c:set var="page" value="${empty param.p?1:param.p}" />
				<c:forEach var="i" begin="1" end="5" step="1">
					<c:choose>
						<c:when test="${i eq page}">
							<li><a class="text-strong"
								href="list?p=${i }&category=${category }&keyword=${keyword}">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li><a class=""
								href="list?p=${i }&category=${category }&keyword=${keyword}">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
			<div class="pager-next"></div>
		</nav>
	</section>
</main>
