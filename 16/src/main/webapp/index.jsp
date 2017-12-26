<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Lab_16</title>
    <script type="text/javascript">
        var ws = null;

        function connect() {
            ws = new WebSocket("ws://localhost:8080/websock");
            ws.onmessage = function (event) {
                document.getElementById('outdiv').innerHTML = event.data;
            };
        }

        function disconnect() {
            ws.close();
        }
    </script>
</head>
<body>
<button onclick="connect()">start</button>
<%--<button onclick="disconnect();">stop</button>--%>
<p></p>
<div id="outdiv"></div>
</body>
</html>
