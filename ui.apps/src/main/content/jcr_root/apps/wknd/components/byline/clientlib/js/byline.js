(function ($, Coral) {
    "use strict";
    console.log("Clientslib loaded");
    var registry = $(window).adaptTo("foundation-registry");
    registry.register("foundation.validation.validator", {
        selector: "[data-validation=geeks-multifield]",
        validate: function (element) {
            var el = $(element);
            let min = el.data("min-items");
            let max = el.data("max-items");
            let items = el.children("coral-multifield-item").length;
            let domItems = el.children("coral-multifield-item");
            console.log("{}:{}:{}", max, min, items);
            if (items > max) {
                domItems.last().remove();
                return "You can add only " + max + ".You can trying to add " + items
            }
            if (items < min) {
                return "You need to add " + min
            }
        }
    });

    registry.register("foundation.validation.validator", {
        selector: "[data-validation=geeks-name-validation]",
        validate: function (element) {
            let el = $(element);
            let pattern =/[\d]/;
            let value = el.val();
            if(pattern.test(value)) {
                return "Please, add only letters in Name field!"
            }
        }
    });
})(jQuery, Coral);
