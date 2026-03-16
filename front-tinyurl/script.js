async function shortenUrl() {

    const url = document.getElementById("urlInput").value;

    const response = await fetch("http://localhost:8080/shorten", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            url: url
        })
    });

    const data = await response.json();

    document.getElementById("result").innerText = data.shortUrl;
}

let urls = []

function generateCode() {
    return Math.random().toString(36).substring(2,8)
}

function shortenUrl() {
    const input = document.getElementById("urlInput")
    const url = input.value

    if(!url) return
        const code = generateCode()
        const shortUrl = {
            code: code,
            original: url,
            clicks: 0
        }

        urls.push(shortUrl)
        render()

        input.value = ""

}

function openUrl(code) {
    const url = urls.find(u => u.code === code)
    url.clicks++
    window.open(url.original)
    render()
}

function deleteUrl(code) {
    urls = urls.filter(u => u.code !== code)
    render()
}

function render() {
    const list = document.getElementById("list")
    list.innerHTML = ""
    urls.forEach(url => {
    list.innerHTML += `

<div class="url-item">

<div class="url-info">

<span class="url-short" onclick="openUrl('${url.code}')">

localhost:8080/${url.code}

</span>

<span>

Clicks: ${url.clicks}

</span>

</div>

<button onclick="deleteUrl('${url.code}')">

Delete

</button>

</div>

`

})

}