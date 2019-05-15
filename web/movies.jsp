<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.song_list.entity.Movie" %>
<%@page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie list</title>
    </head>
    <body>
        <% 
        List<Movie> movies = (List<Movie>) 
                request.getAttribute("movies");
        
        %>
        
        <h1>List of movies (<%= movies.size() %>)</h1>
        
        <table border="1">
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Director</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
                <% for (Movie m: movies) { %>
                <tr>
                    <td><%= m.getId() %></td>
                    <td><%= m.getTitle() %></td>
                    <td><%= m.getDirector() %></td>
                    <td>
                        <a href="movie.html?id=<%=m.getId()%>">View</a>                        
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
