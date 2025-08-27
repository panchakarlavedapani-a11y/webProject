<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Details - WorkNestApp</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { 
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
            background-color: #f8f9fa;
            color: #333;
            line-height: 1.6;
            padding: 20px;
        }
        .container {
            max-width: 900px;
            margin: 0 auto;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }
        h2, h3, h4 {
            color: #2c3e50;
            margin-bottom: 15px;
        }
        h3 {
            padding-bottom: 10px;
            border-bottom: 2px solid #eee;
        }
        p {
            margin-bottom: 15px;
        }
        .back-link {
            display: inline-block;
            margin-bottom: 20px;
            color: #3498db;
            text-decoration: none;
            font-weight: 600;
        }
        .back-link:hover {
            text-decoration: underline;
        }
        .task-info {
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 5px;
            margin-bottom: 30px;
        }
        .comments-section {
            margin-top: 30px;
        }
        .comment {
            background-color: #f8f9fa;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 15px;
        }
        .comment-author {
            font-weight: 600;
            color: #2c3e50;
        }
        .comment-date {
            color: #7f8c8d;
            font-size: 0.9em;
        }
        textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-family: inherit;
            font-size: 16px;
            min-height: 100px;
            resize: vertical;
            margin-bottom: 15px;
        }
        textarea:focus {
            border-color: #3498db;
            outline: none;
        }
        button {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 12px 25px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            font-weight: 600;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #2980b9;
        }
        .status-badge {
            display: inline-block;
            padding: 5px 10px;
            border-radius: 20px;
            font-size: 0.85em;
            font-weight: 600;
        }
        .status-PENDING {
            background-color: #f39c12;
            color: white;
        }
        .status-IN_PROGRESS {
            background-color: #3498db;
            color: white;
        }
        .status-COMPLETED {
            background-color: #2ecc71;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <a href="/worknestapp/user/dashboard" class="back-link">← Back to Dashboard</a>
        <h2>Task Details</h2>
        
        <div class="task-info">
            <h3>${task.title}</h3>
            <p>${task.description}</p>
            <p>Status: <span class="status-badge status-${task.status}">${task.status}</span></p>
            <p>Start: ${task.startDate} | Due: ${task.dueDate}</p>
        </div>

        <div class="comments-section">
            <h4>Comments</h4>
            <c:forEach var="cmt" items="${task.comments}">
                <div class="comment">
                    <div class="comment-author">${cmt.author}</div>
                    <div class="comment-date">${cmt.createdAt}</div>
                    <div class="comment-text">${cmt.text}</div>
                </div>
            </c:forEach>

            <form method="post" action="/worknestapp/user/task/${task.id}/comment">
                <textarea name="text" placeholder="Add a comment..." required></textarea>
                <button type="submit">Add Comment</button>
            </form>
        </div>
    </div>
</body>
</html>

