<%@ include file="./common/header.jspf"%>
<%@ include file="./common/navigation.jspf"%>
	<div class="container">
	
		
		<h1>Welcome ${name} to my Page</h1>
			
	<div class="row text-center flex-wrap" >
        <c:forEach items="${photos}" var="photo">
            <div class="col-md-3 col-sm-6">
                <div class="thumbnail">
                   <img src="${photo.photoUrl}" />
                   <div class="caption">
                       <h4>${photo.title}</h4>
                   </div>
                   <p><fmt:formatDate pattern="dd/MM/yyyy" value = "${photo.targetDate}" /></p>
                   <p>
                     <a type="button" class="btn btn-warning"href="/update-photo?id=${photo.id}">Edit</a> 
					 <a type="button"class="btn btn-danger" href="/delete-photo?id=${photo.id}">Delete</a>
                   </p>
                </div>
            </div>
       </c:forEach>
    </div>
			
	<div> <a type="button" class="btn btn-success" href="/add-photo">Add new Picture</a></div>

	</div>
<%@ include file="./common/footer.jspf"%>
