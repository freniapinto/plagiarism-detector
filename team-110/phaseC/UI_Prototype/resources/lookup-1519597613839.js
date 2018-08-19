(function(window, undefined) {
  var dictionary = {
    "d12245cc-1680-458d-89dd-4f0d7fb22724": "Screen 1",
    "d2fc72ee-e76a-4d7e-b822-0af11de83995": "report overview",
    "3727a818-7ca7-4e2e-b402-cf3066de0c83": "enter git link",
    "40ff5095-5160-43a4-b917-2de13e9a0943": "detailed report",
    "48db1e44-e3cf-499c-a6b0-0e82d45ae3a8": "Compare code page",
    "37b3613f-ee8b-4e35-a290-ef03b58de91e": "running plag",
    "a4c26bf6-ddde-49c5-b9db-ad7745266b87": "user prof",
    "28e6eb4e-03de-48ae-a035-9d2983dc976d": "Thanks for downloading",
    "e73b655d-d3ec-4dcc-a55c-6e0293422bde": "960 grid - 16 columns",
    "ef07b413-721c-418e-81b1-33a7ed533245": "960 grid - 12 columns",
    "f39803f7-df02-4169-93eb-7547fb8c961a": "Template 1",
    "bb8abf58-f55e-472d-af05-a7d1bb0cc014": "default"
  };

  var uriRE = /^(\/#)?(screens|templates|masters|scenarios)\/(.*)(\.html)?/;
  window.lookUpURL = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, url;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      url = folder + "/" + canvas;
    }
    return url;
  };

  window.lookUpName = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, canvasName;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      canvasName = dictionary[canvas];
    }
    return canvasName;
  };
})(window);