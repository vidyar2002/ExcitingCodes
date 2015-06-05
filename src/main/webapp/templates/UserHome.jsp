<!-- ======== @Region: #content ======== -->
<div id="homeContent" ng-controller="ContactController" ng-init="getContactList()">
	<div class="container">
		<!-- Sign Up form -->
		
		<div>
			<form  role="form">
			   <p class="alert-danger">{{message}} </p>
			
				<table>
					<tr>
						<td align=right><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addContactModal" ng-click="addContact('Add', userDto.email)">Add Contact</button></td>
					</tr>
				</table>
				
				<table class="table" width="500px">
				  <tr>
				   <th>First Name</th>
				   <th>Last Name </th>
				   <th>Mobile </th>
				   <th>Email</th>
				   <th></th>
				   </tr>
				  <tr ng-repeat="contactDto in userDto.contactDtoList" ng-if="userDto.contactDtoList != null && 0<userDto.contactDtoList.length">
				     <td> {{contactDto.firstName}} </td>
				     <td> {{contactDto.lastName}} </td>
				     <td>{{contactDto.mobile}}</td>
				     <td>{{contactDto.email}}</td>
				     <td><button type="button" class="btn btn-primary" ng-click="editContact('Edit', userDto.email, contactDto.email)" data-toggle="modal" data-target="#addContactModal">Edit</button>
				     <button type="button" class="btn btn-primary" ng-click="removeContact(userDto.email, contactDto.id)" ng-confirm-click="Are you sure you want to remove the contact?">Remove</button></td>
				   </tr>
				   <tr  ng-if="userDto.contactDtoList == null || 0 == userDto.contactDtoList.length">
				     <td colspan="4" align="center"> No contacts available </td> 
				   </tr>
				 </table>
			</form>
		</div>
			
			<!--  addContactModal -->
		<div class="modal fade" id="addContactModal" tabindex="-1" role="dialog" aria-labelledby="addContactModal" aria-hidden="true" width="400px">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								          <h4 class="modal-title">
								            {{action}} Contact  
								          </h4>								         
								        </div>
										<div class="modal-body">
										    <p class="alert-danger">{{errorMessage}} </p>
										    <div class="form-group">
								              <label class="sr-only" for="contact-first-name">First Name</label>
								              <input type="text" ng-model="contactDto.firstName" class="form-control" id="contact-first-name" placeholder="First name">
								            </div>
								            <div class="form-group">
								              <label class="sr-only" for="contact-last-name">Last Name</label>
								              <input type="text" ng-model="contactDto.lastName" class="form-control" id="contact-last-name" placeholder="Last name">
								            </div>
								            <div class="form-group">
								              <label class="sr-only" for="contact-mobile">Mobile Number</label>
								              <input type="number" ng-model="contactDto.mobile" class="form-control" id="contact-mobile" placeholder="Mobile Number">
								            </div>
								            <div class="form-group">
								              <label class="sr-only" for="contact-email">Email</label>
								              <input type="email" ng-model="contactDto.email" class="form-control" id="contact-email" placeholder="Email">
								              <input type="hidden" ng-model="contactDto.userEmail"/>
								              <input type="hidden" ng-model="contactDto.id"/>
								            </div>
										</div>
										<div class="modal-footer">
										 <button class="btn btn-primary" type="button" ng-click="saveContact(action)">Save</button> &nbsp;&nbsp;&nbsp;&nbsp;
											  &nbsp;&nbsp;&nbsp;&nbsp;  <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
										</div>
									</div>
								</div>
							</div>
								
								
								<!-- end of modal #addContactModal -->
					 

	</div>
	
	</div>