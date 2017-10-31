function OnClick_JSON(n, s) {
    let patern = new RegExp(/^[1-9]+[0-9]*$/);
    if (patern.test(n)) {
        if (req) {
            req.open("POST", "http://localhost:8080/sss_json", true);
            req.onreadystatechange = () => {
                if (req.readyState == 4) {
                    if (req.status == 200) {
                        let soure = req.responseText;
                        let html = '';
                        for (let x in soure) {
                            console.log(soure[x]);
                            html += soure[x];
                            document.getElementById("div_json").innerHTML = "JSON: " + html;
                        }
                    } else alert("status = " + req.status + "\n" + req.statusText);
                }
            };
            req.setRequestHeader("XRand-N", n);
            req.send("null");
        }
    } else alert("error");
}


