function setSearchResult(jsonResult) {
	var searchResults = jsonResult;

	var searchResultContainer = $("#searchResults");
	searchResultContainer.empty();
	if (searchResults) {

		$
				.each(
						searchResults.rows,
						function(i, item) {
							var currentItem = item;
							var listItem = $("<div>", {
								id : item.jobId,
								"class" : "list-group"
							});
							var listHeading = $("<div>", {
								"class" : "list-heading"
							});
							listHeading
									.append('<h4 class="list-group-item-heading">'
											+ currentItem.title + '</h4>');
							if (currentItem.showApply) {
								listHeading
										.append('<button class="btn btn-primary apply-button">Apply</button>')
							}

							var listContent = $("<div>", {
								"class" : "list-content"
							});
							listContent.append('<p class="sub-header">'
									+ currentItem.employer + '</p>');
							listContent.append('<p>Keyskills:'
									+ currentItem.skills + '</p>');
							listContent.append('<p>Summary:'
									+ currentItem.description + '</p>');
							// listContent.append('<p><i class="fa
							// fa-map-marker"></i>
							// '+currentItem.Location+'</p>');
							listContent
									.append('<p><i class="fa fa-calendar"></i> '
											+ currentItem.postedDate + '</p>');

							listItem.append(listHeading);
							listItem.append(listContent);
							searchResultContainer.append(listItem);

						});

		setPagination(searchResults.total, searchResults.page);
	}
}

function setPagination(totalPages, currentPage) {
	var paginationElem = $("#pagination");
	paginationElem.empty();

	var prev = $("<li>", {
		"class" : ((currentPage == 1) ? "disabled" : "")
	});
	prev
			.append('<a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>');

	paginationElem.append(prev);

	for (var i = 0; i < totalPages; i++) {
		var page = $("<li>", {
			"class" : ((i + 1 == currentPage) ? "active" : "")
		});
		page.append('<a href="#">' + (i + 1) + '</a>');
		paginationElem.append(page);
	}

	var next = $("<li>", {
		"class" : ((currentPage == totalPages) ? "disabled" : "")
	});
	next
			.append('<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>');

	paginationElem.append(next);

}

function searchJobsForSkilles() {
	var skill = $("#skills").val();
	$.ajax({
		url : "http://localhost:8080/jobSearch.do",
		type : "POST",
		data : {
			'skills' : skill
		},
		dataType : "json",
		success : function(response) {
			setSearchResult(response);
		}
	});
}

function searchCandidateForSkilles(component){
	var skill = $("#skills").val();
	$.ajax({
		url : "http://localhost:8080/CandidateSearch.do",
		type : "POST",
		data : {
			'skills' : skill
		},
		dataType : "json",
		success : function(response) {
			setCandidateSearchResult(response,component);
		}
	});
}

function setCandidateSearchResult(jsonResult,component){
	var searchResults = jsonResult;

	var searchResultContainer = $(component);
	searchResultContainer.empty();
	if (searchResults) {

		$
				.each(
						searchResults.rows,
						function(i, item) {
							var currentItem = item;
							var listItem = $("<div>", {
								id : item.jobId,
								"class" : "list-group"
							});
							var listHeading = $("<div>", {
								"class" : "list-heading"
							});
							listHeading
									.append('<h4 class="list-group-item-heading">'
											+ currentItem.title + '</h4>');
							if (currentItem.showApply) {
								listHeading
										.append('<button class="btn btn-primary apply-button">Apply</button>')
							}

							var listContent = $("<div>", {
								"class" : "list-content"
							});
							listContent.append('<p class="sub-header">'
									+ currentItem.displayName + '</p>');
							listContent.append('<p>Keyskills:'
									+ currentItem.skills + '</p>');
							listContent.append('<p>Education :'
									+ currentItem.education + '</p>');
							listContent.append('<p>Contact No :'
									+ currentItem.contactNo + '</p>');

							listItem.append(listHeading);
							listItem.append(listContent);
							searchResultContainer.append(listItem);

						});

		setPagination(searchResults.total, searchResults.page);
	}
}

$(document).on('click', '.apply-button', function() {
	var job = $(this).closest(".list-group").attr('id');
	console.log(job);
	$.ajax({
		url : "http://localhost:8080/applyJob.do",
		type : "POST",
		data : {
			'jobId' : job
		},
		dataType : "json",
		complete : function(response) {
			alert("Applied Successfully");
			location.reload();
		}

	});
});


