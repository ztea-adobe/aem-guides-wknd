import $ from 'jquery';
let jsHelloWorld = () => {
    const jsString = "Hello World";
    console.log($(document));
    let SEARCH_API_ENDPOINT = "https://api.dvidshub.net/search?q=tank&api_key=key-664f9e8def833";
    $.ajax({
        url: SEARCH_API_ENDPOINT,
        method: "GET",
        success: function (data, status, xhr) {
            console.log(data);
            console.log(status);
            console.log(xhr);
        },
        error: function (xhr, status, err) {
            console.log('There was an error getting search results');

        }, always: function (data, textStatus, errorThrown) {
            console.log('always completed.');
        }
    });
};
export default jsHelloWorld();
