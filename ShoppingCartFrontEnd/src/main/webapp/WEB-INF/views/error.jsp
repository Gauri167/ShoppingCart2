<head>
 <script type="text/javascript" src="<c:url value="/resources/js/jquery.js"/>"></script>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet" id="bootstrap-css">
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"/></script>
</head>

<body>
<jsp:include page="newHeader.jsp"></jsp:include>
		
		<div class="content">
		
			<div class="container">
			
				<div class="row">
				
					<div class="col-xs-12">
					
						
						<div class="jumbotron">
						
							<h1>Something went wrong talk to support team!${errorTitle}</h1>
							<hr/>
						
							<blockquote style="word-wrap:break-word">
								
								${errorDescription}
							
							</blockquote>						
						
						</div>
						
											
					</div>					
				
				</div>
			
			</div>
							
		</div>

		
		<jsp:include page="newfooter.jsp"></jsp:include>
</body>