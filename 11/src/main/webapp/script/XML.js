let req = new window.XMLHttpRequest();

function Fill(req) {
    let tsnum = req.responseXML.getElementsByTagName("num");
    console.log(tsnum);
    let html = "";
    for (let x in tsnum.toString()) {
        html += tsnum[x].innerHTML + "    ";
        document.getElementById("div_xml").innerHTML = "XML: " + html;
    }
}

function OnClick_XML(n) {
    let patern = new RegExp(/^[1-9]+[0-9]*$/);
    if (patern.test(n)) {
        req.open("POST", "http://localhost:8080/sss_xml", true);
        req.onreadystatechange = () => {
            if (req.readyState === 4) {
                if (req.status === 200) {
                    Fill(req);
                } else alert("status = " + req.status + "\n" + req.statusText);
            }
        };
        req.setRequestHeader("XRand-N", n);
        req.send("null");
    }
}