@param String name
@param com.example.springbootjtedemo.hello.PageInfo pageInfo
@param java.util.List<com.example.springbootjtedemo.hello.Book> books

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${pageInfo.title()}</title>
    <meta title="${pageInfo.title()}" content="${pageInfo.content()}">
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h1>${pageInfo.title()}</h1>
<h2>Welcome, ${name}</h2>

<p>Here's the list of books rendered via a Spring Boot Application using the new Java Templating Engine!</p>
<table>
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Author</th>
    </tr>
    @if(books.isEmpty())
        <tr>
            <th colspan="3">No books available!</th>
        </tr>
    @else
    @for(com.example.springbootjtedemo.hello.Book book: books)
        <tr>
            <td>${book.isbn()}</td>
            <td>${book.title()}</td>
            <td>${book.author()}</td>
        </tr>
    @endfor
</table>
@endif
</body>
</html>