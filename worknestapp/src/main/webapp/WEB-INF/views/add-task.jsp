<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Task - WorkNestApp</title>
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
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }
        h2 {
            color: #2c3e50;
            margin-bottom: 25px;
            padding-bottom: 10px;
            border-bottom: 2px solid #eee;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: #2c3e50;
        }
        input[type="text"], 
        input[type="password"], 
        textarea, 
        select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-family: inherit;
            font-size: 16px;
            transition: border 0.3s ease;
        }
        input[type="text"]:focus, 
        input[type="password"]:focus, 
        textarea:focus, 
        select:focus {
            border-color: #3498db;
            outline: none;
        }
        textarea {
            min-height: 120px;
            resize: vertical;
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
    </style>
</head>
<body>
    <div class="container">
        <a href="/worknestapp/admin/dashboard" class="back-link">← Back to Dashboard</a>
        <h2>Add Task</h2>
        <form method="post" action="/worknestapp/admin/tasks/add">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description"></textarea>
            </div>
            <div class="form-group">
                <label for="startDate">Start Date (YYYY-MM-DD):</label>
                <input type="text" id="startDate" name="startDate" required>
            </div>
            <div class="form-group">
                <label for="dueDate">Due Date (YYYY-MM-DD):</label>
                <input type="text" id="dueDate" name="dueDate" required>
            </div>
            <div class="form-group">
                <label for="assignedTo">Assign To:</label>
                <select id="assignedTo" name="assignedTo" required>
                    <c:forEach var="u" items="${users}">
                        <option value="${u.id}">${u.username}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit">Create Task</button>
        </form>
    </div>
</body>
</html>