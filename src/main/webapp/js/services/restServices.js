cms.factory("restServices", function($resource) {
    return $resource("", null,
    {
    	"saveContact"   	   :  {method:"POST", url:"rest/contact/saveContact"},
    	"checkContactExists"   :  {method:"POST", url:"rest/contact/checkContactExists"},
    	"findContactDetails"  : {method:"POST", url:"rest/contact/findContactDetails"},
    	"getContactList"   :  {method:"POST", url:"rest/contact/getContactList"},
    	"removeContact"   :  {method:"POST", url:"rest/contact/removeContact"},
    	"checkEmailExists" :  {method:"POST", url:"rest/user/checkEmailExists"},
    	"addUser":	  		  {method:"POST", url:"rest/user/addUser"},
    	"authenticateUser" :  {method:"POST", url:"/login"}
    });
});