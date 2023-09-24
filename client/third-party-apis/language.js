// Define the URL of the translation API
const apiUrl = 'https://libretranslate.de/translate';

// Get references to the HTML elements
const sourceLanguageSelect = document.getElementById('sourceLanguage');
const targetLanguageSelect = document.getElementById('targetLanguage');
const sourceTextArea = document.getElementById('sourceText');
const translatedTextArea = document.getElementById('translatedText');
const translateButton = document.getElementById('translateButton');

// Add an event listener to the translateButton
translateButton.addEventListener('click', () => {
    // Get the selected source and target languages
    const sourceLanguage = sourceLanguageSelect.value;
    const targetLanguage = targetLanguageSelect.value;

    // Get the text to translate
    const textToTranslate = sourceTextArea.value;

    // Make a POST request to the translation API
    fetch(apiUrl, {
        method: 'POST',
        body: JSON.stringify({
            q: textToTranslate,
            source: sourceLanguage,
            target: targetLanguage,
        }),
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then((response) => response.json())
        .then((data) => {
            // Display the translated text
            translatedTextArea.value = data.translatedText;
        })
        .catch((error) => {
            console.error('Translation error:', error);
        });
});

