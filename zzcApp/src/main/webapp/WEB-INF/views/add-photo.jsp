<%@ include file="./common/header.jspf"%>
<%@ include file="./common/navigation.jspf"%>
	<h1>Welcome my Add Todo Page:</h1>
	
		<div class="container">
			Your New Action Item:
			<form:form method="POST"  commandName="photo">
			<form:hidden path="id"/>
				<fieldset class="form-group">
					<form:label path="photoUrl">Photo Url</form:label> 
					<form:input path="photoUrl" type="text" 
						class="form-control" /> <BR />
					<form:errors path="photoUrl" cssClass ="text-danger" />	
				</fieldset>
				
				<fieldset class="form-group">
					<form:label path="title">Title</form:label> 
					<form:input path="title" type="text" 
						class="form-control" /> <BR />
					<form:errors path="title" cssClass ="text-danger" />	
				</fieldset>
				<fieldset class="form-group">
					<form:label path="targetDate">Target Date</form:label> 
					<form:input path="targetDate" type="text" 
						class="form-control" /> <BR />
					<form:errors path="targetDate" cssClass ="text-danger" />	
				</fieldset>
				
				<input name="add" href="/photo-list" type="submit" class="btn btn-success" value="Submit" />
			</form:form>
		</div>
	
	
	
	<%@ include file="./common/footer.jspf"%>
