function OnClick_Header(x, y, z) {
    var req = new window.XMLHttpRequest();
    var patern = new RegExp(/^[0-9]*\.?[0-9]+$/);
    if (patern.test(x.value) && patern.test(y.value)) {
        req.open("POST", "http://localhost:8080/sss_header", true);
        req.onreadystatechange = () => {
            if (req.readyState === 4) {
                if (req.status === 200) {
                    z.value = req.getResponseHeader("Value-z");
                }
                else alert("status = " + req.status + "\n" + req.statusText);
            }
        };
        req.setRequestHeader("Value-x", x.value);
        req.setRequestHeader("Value-y", y.value);
        req.send("null");
    }
}
