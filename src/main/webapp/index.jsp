<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">

        <!-- Optional theme -->

        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Weather search</title>
        <script type="text/javascript">
            function isTest()
            {
               


              
                var zip = $("#zip").val();
             
                var url = "weatherJson/" + zip;
                $.ajax({
      url: url,
      async: false,  
      success:function(data) {
          
         var result ="<h3>Result for Zip code " + zip+ "</h3>";
       var obj = jQuery.parseJSON(data);
      if (obj.valid)
      {
         result = "<h4><b> City :</b>" + obj.city + "</h4>";  
         result =  result + "<h4> <b>State : </b>" + obj.state + "</h4>";  
           result =  result + "<h4> <b>Temperature (f) </b>" + obj.temp_f + "</h4>";  
      }
      else
      {
          result = result +  "<h4>" + obj.errorMessage + "</h4>";
      }
         
        $("#model").html(result);

      }
   });
                
                
                return false;
            }

           
        </script>
    </head>
    <body>
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        ...
    </nav>

    <div class="jumbotron">
        <h1>Find weather based on Zip code</h1>


    </div>
     
    <div class="page-header">
        <span class="navbar navbar-default">  <h1>Zip Code</h1></span>
        <div class="list-group">
            <form class="navbar-form navbar-left" role="search">

                <input  id ="zip" type="text" class="form-control" placeholder="Zip code to find weather">
                </div>
              
            </form>
           <button id="search" type="submit" class="btn btn-default" onclick="isTest()">Submit</button>
        </div>
    </div>

<div id ="model" class="modal-body">  
<h4></h4>  
              
</div>  


-

</body>
</html>
