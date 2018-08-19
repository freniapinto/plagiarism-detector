jQuery("#simulation")
  .on("click", ".s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 .click", function(event, data) {
    var jEvent, jFirer, cases;
    if(data === undefined) { data = event; }
    jEvent = jimEvent(event);
    jFirer = jEvent.getEventFirer();
    if(jFirer.is("#s-Label_4")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/3727a818-7ca7-4e2e-b402-cf3066de0c83"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_5")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/40ff5095-5160-43a4-b917-2de13e9a0943"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_6")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/a4c26bf6-ddde-49c5-b9db-ad7745266b87"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_37")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimNavigation",
                  "parameter": {
                    "target": "screens/d12245cc-1680-458d-89dd-4f0d7fb22724",
                    "transition": "slidedown"
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_58")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimShow",
                  "parameter": {
                    "target": [ "#s-Text_5" ],
                    "effect": {
                      "type": "slide",
                      "duration": 500,
                      "direction": "up"
                    }
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Text_5")) {
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimHide",
                  "parameter": {
                    "target": [ "#s-Input-text_1","#s-Label_5","#s-Label_7","#s-Label_6","#s-Input-text","#s-Label_4","#s-Input_2","#s-Rectangle_1","#s-Input_1" ]
                  },
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      event.data = data;
      jEvent.launchCases(cases);
    }
  })
  .on("mouseenter dragenter", ".s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 .mouseenter", function(event, data) {
    var jEvent, jFirer, cases;
    if(data === undefined) { data = event; }
    jEvent = jimEvent(event);
    jFirer = jEvent.getDirectEventFirer(this);
    if(jFirer.is("#s-Label_5") && jFirer.has(event.relatedTarget).length === 0) {
      event.backupState = true;
      event.target = jFirer;
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_5": {
                      "attributes": {
                        "width": "jimEvent.fn.getCurrentStyle('width', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_5') + jimEvent.fn.getCurrentStyle('padding-left', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_5') + jimEvent.fn.getCurrentStyle('padding-right', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_5') - 14 - 0",
                        "height": "jimEvent.fn.getCurrentStyle('height', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_5') + jimEvent.fn.getCurrentStyle('padding-top', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_5') + jimEvent.fn.getCurrentStyle('padding-bottom', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_5') - 0 - 0",
                        "padding-top": "6px",
                        "padding-right": "6px",
                        "padding-bottom": "6px",
                        "padding-left": "20px",
                        "background-color": "#EEEEEE",
                        "background-image": "none",
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#EEEEEE",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#EEEEEE",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#EEEEEE",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#EEEEEE",
                        "border-radius": "11px 11px 11px 11px"
                      },
                      "expressions": {
                        "width": "Math.max(329 - 1 - 1 - 20 - 6, 0) + 'px'",
                        "height": "Math.max(126 - 1 - 1 - 6 - 6, 0) + 'px'"
                      }
                    }
                  },{
                    "#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_5": {
                      "attributes-ie": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#EEEEEE",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#EEEEEE",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#EEEEEE",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#EEEEEE",
                        "border-radius": "11px 11px 11px 11px",
                        "padding-top": "6px",
                        "padding-right": "6px",
                        "padding-bottom": "6px",
                        "padding-left": "20px",
                        "-pie-background": "#EEEEEE",
                        "-pie-poll": "false"
                      },
                      "expressions-ie": {
                        "width": "Math.max(329 - 1 - 1 - 20 - 6, 0) + 'px'",
                        "height": "Math.max(126 - 1 - 1 - 6 - 6, 0) + 'px'"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      jEvent.launchCases(cases);
    } else if(jFirer.is("#s-Label_7") && jFirer.has(event.relatedTarget).length === 0) {
      event.backupState = true;
      event.target = jFirer;
      cases = [
        {
          "blocks": [
            {
              "actions": [
                {
                  "action": "jimChangeStyle",
                  "parameter": [ {
                    "#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_7": {
                      "attributes": {
                        "width": "jimEvent.fn.getCurrentStyle('width', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_7') + jimEvent.fn.getCurrentStyle('padding-left', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_7') + jimEvent.fn.getCurrentStyle('padding-right', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_7') - 14 - 0",
                        "height": "jimEvent.fn.getCurrentStyle('height', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_7') + jimEvent.fn.getCurrentStyle('padding-top', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_7') + jimEvent.fn.getCurrentStyle('padding-bottom', '#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_7') - 0 - 0",
                        "padding-top": "6px",
                        "padding-right": "6px",
                        "padding-bottom": "6px",
                        "padding-left": "20px",
                        "background-color": "#EEEEEE",
                        "background-image": "none",
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#EEEEEE",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#EEEEEE",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#EEEEEE",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#EEEEEE",
                        "border-radius": "12px 12px 12px 12px"
                      },
                      "expressions": {
                        "width": "Math.max(329 - 1 - 1 - 20 - 6, 0) + 'px'",
                        "height": "Math.max(130 - 1 - 1 - 6 - 6, 0) + 'px'"
                      }
                    }
                  },{
                    "#s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 #s-Label_7": {
                      "attributes-ie": {
                        "border-top-width": "1px",
                        "border-top-style": "solid",
                        "border-top-color": "#EEEEEE",
                        "border-right-width": "1px",
                        "border-right-style": "solid",
                        "border-right-color": "#EEEEEE",
                        "border-bottom-width": "1px",
                        "border-bottom-style": "solid",
                        "border-bottom-color": "#EEEEEE",
                        "border-left-width": "1px",
                        "border-left-style": "solid",
                        "border-left-color": "#EEEEEE",
                        "border-radius": "12px 12px 12px 12px",
                        "padding-top": "6px",
                        "padding-right": "6px",
                        "padding-bottom": "6px",
                        "padding-left": "20px",
                        "-pie-background": "#EEEEEE",
                        "-pie-poll": "false"
                      },
                      "expressions-ie": {
                        "width": "Math.max(329 - 1 - 1 - 20 - 6, 0) + 'px'",
                        "height": "Math.max(130 - 1 - 1 - 6 - 6, 0) + 'px'"
                      }
                    }
                  } ],
                  "exectype": "serial",
                  "delay": 0
                }
              ]
            }
          ],
          "exectype": "serial",
          "delay": 0
        }
      ];
      jEvent.launchCases(cases);
    }
  })
  .on("mouseleave dragleave", ".s-a4c26bf6-ddde-49c5-b9db-ad7745266b87 .mouseleave", function(event, data) {
    var jEvent, jFirer, cases;
    if(data === undefined) { data = event; }
    jEvent = jimEvent(event);
    jFirer = jEvent.getDirectEventFirer(this);
    if(jFirer.is("#s-Label_5")) {
      jEvent.undoCases(jFirer);
    } else if(jFirer.is("#s-Label_7")) {
      jEvent.undoCases(jFirer);
    }
  });