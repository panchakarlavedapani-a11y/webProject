<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - WorkNestApp</title>
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
            max-width: 1200px;
            margin: 0 auto;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }
        h2, h3 {
            color: #2c3e50;
            margin-bottom: 20px;
        }
        h2 {
            padding-bottom: 10px;
            border-bottom: 2px solid #eee;
        }
        .header-actions {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
            flex-wrap: wrap;
            gap: 15px;
        }
        .nav-tabs {
            display: flex;
            gap: 10px;
            margin-bottom: 20px;
        }
        .tab {
            padding: 10px 20px;
            background-color: #f8f9fa;
            color: #2c3e50;
            text-decoration: none;
            border-radius: 5px;
            font-weight: 600;
            transition: all 0.3s ease;
        }
        .tab:hover, .tab.active {
            background-color: #3498db;
            color: white;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: 600;
            transition: all 0.3s ease;
        }
        .btn:hover {
            background-color: #2980b9;
        }
        .btn-logout {
            background-color: #e74c3c;
        }
        .btn-logout:hover {
            background-color: #c0392b;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f8f9fa;
            font-weight: 600;
            color: #2c3e50;
        }
        tr:hover {
            background-color: #f8f9fa;
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
        .task-link {
            color: #3498db;
            text-decoration: none;
            font-weight: 600;
        }
        .task-link:hover {
            text-decoration: underline;
        }
        @media (max-width: 768px) {
            table {
                display: block;
                overflow-x: auto;
            }
            .header-actions {
                flex-direction: column;
                align-items: flex-start;
            }
            .nav-tabs {
                flex-wrap: wrap;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header-actions">
            <h2>Admin Dashboard</h2>
            <a href="/worknestapp/logout" class="btn btn-logout">Logout</a>
        </div>
        
        <div class="nav-tabs">
            <a href="/worknestapp/admin/users" class="tab">Manage Users</a>
            <a href="/worknestapp/admin/tasks/add" class="tab">Add Task</a>
        </div>
        
        <h3>All Tasks</h3>
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Assigned To</th>
                    <th>Status</th>
                    <th>Due Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="t" items="${tasks}">
                    <tr>
                        <td><a href="/worknestapp/user/task/${t.id}" class="task-link">${t.title}</a></td>
                        <td>${t.assignedTo.username}</td>
                        <td><span class="status-badge status-${t.status}">${t.status}</span></td>
                        <td>${t.dueDate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>