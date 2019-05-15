<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.song_list.ManualSongEntity" %>
<%@page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Songs list</title>
    </head>
    <body>
        <% 
        List<ManualSongEntity> songs = (List<ManualSongEntity>) 
                request.getAttribute("songs");
        
        %>
        
        <h1>Song list <%= songs.size() %></h1>
    </body>
</html>
