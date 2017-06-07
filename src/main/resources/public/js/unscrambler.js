
window.onload = function() {
    const lettersInput = document.getElementById("letters");
    lettersInput.addEventListener("input", () => {
        loadWords();
    });
};

function loadWords() {
    let xhr = new XMLHttpRequest();
    const param = getParameters();
    const lang = param.lang;
    const letters = param.letters;
    xhr.open('GET', lang + '/word/' + letters);
    xhr.onload = function() {
        if (xhr.status === 200) {
            renderWords(xhr.responseText);
        }
        else {
            renderErrors();
        }
    };
    xhr.send();
}

function getParameters() {
    const lang = document.getElementById('lang').textContent;
    const letters = document.getElementById('letters').value;
    return {
        lang: lang,
        letters: letters
    }
}

function renderWords(responseText) {
    const words = JSON.parse(responseText);
    if (words.length === 0) {
        document.getElementById('result').innerHTML = "";
        return;
    }
    let result = '<ul>';
    words.forEach(el => {
        result += '<li>' + el.string + '</li>'
    });
    result += '</ul>';
    document.getElementById('result').innerHTML = result;
}

function renderErrors() {
    if (document.getElementById("letters").value === ''){
        document.getElementById('result').innerHTML = '';
    } else {
        document.getElementById('result').innerHTML = 'Request failed.';
    }

}
