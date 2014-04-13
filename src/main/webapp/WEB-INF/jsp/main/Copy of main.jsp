
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Flat Dream</title>
	<jsp:include page="/WEB-INF/jsp/cmn/inc/headerResource.jsp"/>
    
</head>
<body class="animated">

<div id="cl-wrapper">

  <div class="cl-sidebar">
    <div class="cl-toggle"><i class="fa fa-bars"></i></div>
    <div class="cl-navblock">
      <div class="menu-space">
        <div class="content">
          <div class="sidebar-logo">
            <div class="logo">
                <a href="index2.html"></a>
            </div>
          </div>
          <div class="side-user">
            <div class="avatar"><img src="images/avatar6.jpg" alt="Avatar" /></div>
            <div class="info">
              <p>40 <b>GB</b> / 100 <b>GB</b><span><a href="#"><i class="fa fa-plus"></i></a></span></p>
              <div class="progress progress-user">
                <div class="progress-bar" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                  <span class="sr-only">50% Complete (success)</span>
                </div>
              </div>
            </div>
          </div>
          <ul class="cl-vnavigation">
            <li  ><a href="index.html"><i class="fa fa-home"></i><span>Dashboard</span></a></li>
            <li><a href="#"><i class="fa fa-desktop"></i><span>Layouts</span></a>
              <ul class="sub-menu">
                <li><a href="layout-boxed.html"><span class="label label-primary pull-right">New</span>Boxed Layout</a></li>
                <li><a href="layout-topbar.html"><span class="label label-primary pull-right">New</span>Top Menu</a></li>
              </ul>
            </li>
            <li><a href="#"><i class="fa fa-smile-o"></i><span>UI Elements</span></a>
              <ul class="sub-menu">
                <li  ><a href="ui-elements.html">General</a></li>
                <li  ><a href="ui-alerts.html">Alerts</a></li>
                <li  ><a href="ui-porlets.html"><span class="label label-primary pull-right">New</span>Porlets</a></li>
                <li  ><a href="ui-buttons.html">Buttons</a></li>
                <li  ><a href="ui-modals.html">Modals</a></li>
                <li  ><a href="ui-notifications.html">Notifications</a></li>
                <li  ><a href="ui-tiles.html"><span class="label label-primary pull-right">New</span>Tiles</a></li>
                <li  ><a href="ui-progress.html">Progress Bars</a></li>
                <li  ><a href="ui-icons.html">Icons</a></li>
                <li  ><a href="ui-grid.html">Grid</a></li>
                <li  ><a href="ui-tabs-accordions.html">Tabs & Accordions</a></li>
                <li  ><a href="ui-nestable-lists.html">Nestable Lists</a></li>
                <li  ><a href="ui-treeview.html">Tree View</a></li>
                <li  ><a href="ui-calendar.html"><span class="label label-primary pull-right">New</span>Calendar</a></li>
              </ul>
            </li>
            <li><a href="#"><i class="fa fa-list-alt"></i><span>Forms</span></a>
              <ul class="sub-menu">
                <li  ><a href="form-elements.html">Components</a></li>
                <li  ><a href="form-multiselect.html"><span class="label label-primary pull-right">New</span>Multiselect</a></li>
                <li  ><a href="form-validation.html">Validation</a></li>
                <li  ><a href="form-wizard.html">Wizard</a></li>
                <li  ><a href="form-masks.html">Input Masks</a></li>
                <li  ><a href="form-wysiwyg.html">WYSIWYG Editor</a></li>
                <li  ><a href="form-upload.html">Multi Upload</a></li>
              </ul>
            </li>
            <li><a href="#"><i class="fa fa-table"></i><span>Tables</span></a>
              <ul class="sub-menu">
                <li  ><a href="tables-general.html">General</a></li>
                <li  ><a href="tables-datatables.html"><span class="label label-primary pull-right">New</span>Data Tables</a></li>
                <li class="active" ><a href="tables-xeditable.html"><span class="label label-primary pull-right">New</span>X-Editable</a></li>
              </ul>
            </li>
            <li><a href="#"><i class="fa fa-map-marker nav-icon"></i><span>Maps</span></a>
              <ul class="sub-menu">
                <li  ><a href="maps.html">Maps</a></li>
                <li  ><a href="vector-maps.html">Vector Maps</a></li>
              </ul>
            </li>
            <li><a href="#"><i class="fa fa-envelope nav-icon"></i><span>Email</span></a>
              <ul class="sub-menu">
                <li  ><a href="email-inbox.html">Inbox</a></li>
                <li  ><a href="email-read.html">Email Detail</a></li>
              </ul>
            </li>
            <li  ><a href="typography.html"><i class="fa fa-text-height"></i><span>Typography</span></a></li>
            <li  ><a href="charts.html"><i class="fa fa-bar-chart-o"></i><span>Charts</span></a></li>
            <li><a href="#"><i class="fa fa-file"></i><span>Pages</span></a>
              <ul class="sub-menu">
                <li  ><a href="pages-blank.html">Blank Page</a></li>
                <li  ><a href="pages-blank-header.html">Blank Page Header</a></li>
                <li  ><a href="pages-blank-aside.html">Blank Page Aside</a></li>
                <li  ><a href="pages-blank-aside-header.html"><span class="label label-primary pull-right">New</span>Blank Page Aside Header</a></li>
                <li  ><a href="pages-profile.html"><span class="label label-primary pull-right">New</span>Profile</a></li>
                <li><a href="pages-login.html">Login</a></li>
                <li><a href="pages-sign-up.html"><span class="label label-primary pull-right">New</span>Sign Up</a></li>
                <li><a href="pages-forgot.html"><span class="label label-primary pull-right">New</span>Forgot Password</a></li>
                <li><a href="pages-404.html">404 Page</a></li>
                <li><a href="pages-500.html">500 Page</a></li>
                <li  ><a href="pages-tour.html"><span class="label label-primary pull-right">New</span>Tour Guide</a></li>
                <li  ><a href="pages-gallery.html">Gallery</a></li>
                <li  ><a href="pages-search.html"><span class="label label-primary pull-right">New</span>Search</a></li>
                <li  ><a href="pages-timeline.html">Timeline</a></li>
                <li  ><a href="pages-code-editor.html">Code Editor</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
      <div class="text-right collapse-button" style="padding:7px 9px;">
        <input type="text" class="form-control search" placeholder="Search..." />
        <button id="sidebar-collapse" class="btn btn-default" style=""><i style="color:#fff;" class="fa fa-angle-left"></i></button>
      </div>
    </div>
  </div>
	<div class="container-fluid" id="pcont">
   <!-- TOP NAVBAR -->
  <div id="head-nav" class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-collapse">
        <ul class="nav navbar-nav navbar-right user-nav">
          <li class="dropdown profile_menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img alt="Avatar" src="images/avatar6-2.jpg" /><span>Jane Smith</span> <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#">My Account</a></li>
              <li><a href="#">Profile</a></li>
              <li><a href="#">Messages</a></li>
              <li class="divider"></li>
              <li><a href="#">Sign Out</a></li>
            </ul>
          </li>
        </ul>			
        <ul class="nav navbar-nav not-nav">
          <li class="button dropdown">
            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class=" fa fa-inbox"></i></a>
            <ul class="dropdown-menu messages">
              <li>
                <div class="nano nscroller">
                  <div class="content">
                    <ul>
                      <li>
                        <a href="#">
                          <img src="images/avatar2.jpg" alt="avatar" /><span class="date pull-right">13 Sept.</span> <span class="name">Daniel</span> Hey! How are you?
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <img src="images/avatar_50.jpg" alt="avatar" /><span class="date pull-right">20 Oct.</span><span class="name">Adam</span> Hi! Can you fix my phone?
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <img src="images/avatar4_50.jpg" alt="avatar" /><span class="date pull-right">2 Nov.</span><span class="name">Michael</span> Regards!
                        </a>
                      </li>
                      <li>
                        <a href="#">
                          <img src="images/avatar3_50.jpg" alt="avatar" /><span class="date pull-right">2 Nov.</span><span class="name">Lucy</span> Hello, my name is Lucy
                        </a>
                      </li>
                    </ul>
                  </div>
                </div>
                <ul class="foot"><li><a href="#">View all messages </a></li></ul>           
              </li>
            </ul>
          </li>
          <li class="button dropdown">
            <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-globe"></i><span class="bubble">2</span></a>
            <ul class="dropdown-menu">
              <li>
                <div class="nano nscroller">
                  <div class="content">
                    <ul>
                      <li><a href="#"><i class="fa fa-cloud-upload info"></i><b>Daniel</b> is now following you <span class="date">2 minutes ago.</span></a></li>
                      <li><a href="#"><i class="fa fa-male success"></i> <b>Michael</b> commented on your link <span class="date">15 minutes ago.</span></a></li>
                      <li><a href="#"><i class="fa fa-bug warning"></i> <b>Mia</b> commented on post <span class="date">30 minutes ago.</span></a></li>
                      <li><a href="#"><i class="fa fa-credit-card danger"></i> <b>Andrew</b> sent you a request <span class="date">1 hour ago.</span></a></li>
                    </ul>
                  </div>
                </div>
                <ul class="foot"><li><a href="#">View all activity </a></li></ul>           
              </li>
            </ul>
          </li>
          <li class="button"><a class="toggle-menu menu-right push-body" href="javascript:;" class="speech-button"><i class="fa fa-comments"></i></a></li>				
        </ul>

      </div><!--/.nav-collapse animate-collapse -->
    </div>
  </div>
  
    
	<div class="cl-mcont">      <div class="page-head">
        <ol class="breadcrumb">
          <li><a href="#">Home</a></li>
          <li><a href="#">Tables</a></li>
          <li class="active">X-editable</li>
        </ol>
      </div>	
			<div class="row">
				<div class="col-md-12">
					<div class="block-flat">
						<div class="header">							
							<h3>X-Editable</h3>
						</div>
						<div class="content">
							<div class="table-responsive">
            <table style="clear: both" class="table table-bordered table-striped" id="user">
                <tbody> 
                    <tr>         
                        <td width="35%">Simple text field</td>
                        <td width="65%"><a href="#" id="username" data-type="text" data-title="Enter username">superuser</a></td>
                    </tr>
                    <tr>         
                        <td>Empty text field, required</td>
                        <td><a data-title="Enter your firstname"  data-placement="right" data-pk="1" data-type="text" id="firstname" href="#" class="editable editable-click editable-empty"></a></td>
                    </tr>  
                    <tr>         
                        <td>Select, local array, custom display</td>
                        <td><a data-title="Select sex" data-value="" data-pk="1" data-type="select" id="sex" href="#" class="editable editable-click" style="color: gray;">not selected</a></td>
                    </tr>
                    <tr>         
                        <td>Select, remote array, no buttons</td>
                        <td><a data-title="Select group" data-value="1" data-pk="1" data-type="select" id="group" href="#" class="editable editable-click">Admin</a></td>
                    </tr> 
                    <tr>         
                        <td>Select, error while loading</td>
                        <td><a data-title="Select status" data-source="/status" data-value="0" data-pk="1" data-type="select" id="status" href="#" class="editable editable-click">Active</a></td>
                    </tr>  
                    <tr>         
                        <td>Combodate (date)</td>
                        <td><a id="dob" href="#" data-title="Select Date of birth" data-pk="1" data-template="D / MMM / YYYY" data-viewformat="DD/MM/YYYY" data-format="YYYY-MM-DD" data-value="1984-05-15" data-type="combodate" class="editable editable-click">15/05/1984</a></td>
                    </tr> 
                    <tr>         
                        <td>Combodate (datetime)</td>
                        <td><a id="event" href="#" data-title="Setup event date and time" data-pk="1" data-viewformat="MMM D, YYYY, HH:mm" data-format="YYYY-MM-DD HH:mm" data-template="D MMM YYYY  HH:mm" data-type="combodate"  class="editable editable-click editable-empty">Empty</a></td>
                    </tr> 
                    <tr>         
                        <td>Textarea, buttons below. Submit by <i>ctrl+enter</i></td>
                        <td><a data-title="Enter comments" data-placeholder="Your comments here..." data-pk="1" data-type="textarea" id="comments" href="#" class="editable editable-pre-wrapped editable-click">awesome user!</a></td>
                    </tr> 
                    <tr>         
                        <td>Twitter typeahead.js</td>
                        <td><a id="state2" class="editable editable-click" data-title="Start typing State.." data-placement="right" data-pk="1" data-type="typeaheadjs" href="#" data-original-title="" title="">California</a></td>
                    </tr>                       
                    <tr>         
                        <td>Checklist</td>
                        <td><a data-title="Select fruits" data-value="2,3" data-type="checklist" id="fruits" href="#" class="editable editable-click">peach<br>apple</a></td>
                    </tr>
                    <tr>         
                        <td>Select2 (tags mode)</td>
                        <td><a data-title="Enter tags" data-pk="1" data-type="select2" id="tags" href="#" class="editable editable-click">html, javascript</a></td>
                    </tr>                    
                    <tr>         
                        <td>Select2 (dropdown mode)</td>
                        <td><a data-title="Select country" data-value="BS" data-pk="1" data-type="select2" id="country" href="#" class="editable editable-click">Bahamas</a></td>
                    </tr>  
                </tbody>
            </table>
              </div>
						</div>
					</div>				
				</div>
			</div>
	</div>
	
	</div> 
	
</div>
<!-- Right Chat-->
<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right side-chat">
	<div class="header">
    <h3>Chat</h3>
  </div>
  <div class="sub-header" href="#">
    <div class="icon"><i class="fa fa-user"></i></div> <p>Online (4)</p>
  </div>
  <div class="content">
    <p class="title">Family</p>
    <ul class="nav nav-pills nav-stacked contacts">
      <li class="online"><a href="#"><i class="fa fa-circle-o"></i> Michael Smith</a></li>
      <li class="online"><a href="#"><i class="fa fa-circle-o"></i> John Doe</a></li>
      <li class="online"><a href="#"><i class="fa fa-circle-o"></i> Richard Avedon</a></li>
      <li class="busy"><a href="#"><i class="fa fa-circle-o"></i> Allen Collins</a></li>
    </ul>
    
    <p class="title">Friends</p>
    <ul class="nav nav-pills nav-stacked contacts">
      <li class="online"><a href="#"><i class="fa fa-circle-o"></i> Jaime Garzon</a></li>
      <li class="outside"><a href="#"><i class="fa fa-circle-o"></i> Dave Grohl</a></li>
      <li><a href="#"><i class="fa fa-circle-o"></i> Victor Jara</a></li>
    </ul>   
    
    <p class="title">Work</p>
    <ul class="nav nav-pills nav-stacked contacts">
      <li><a href="#"><i class="fa fa-circle-o"></i> Ansel Adams</a></li>
      <li><a href="#"><i class="fa fa-circle-o"></i> Gustavo Cerati</a></li>
    </ul>
    
  </div>
  <div id="chat-box">
    <div class="header">
      <span>Richard Avedon</span>
      <a class="close"><i class="fa fa-times"></i></a>
    </div>
    <div class="messages nano nscroller">
      <div class="content">
        <ul class="conversation">
          <li class="odd">
            <p>Hi Jane, how are you?</p>
          </li>
          <li class="text-right">
            <p>Hello I was looking for you</p>
          </li>
          <li class="odd">
            <p>Tell me what you need?</p>
          </li>
          <li class="text-right">
            <p>Sorry, I'm late... see you</p>
          </li>
          <li class="odd unread">
            <p>OK, call me later...</p>
          </li>
        </ul>
      </div>
    </div>
    <div class="chat-input">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Enter a message...">
        <span class="input-group-btn">
        <button type="button" class="btn btn-primary">Send</button>
        </span>
      </div>
    </div>
  </div>
</nav>
  
	

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
  
  <div id="color-switcher">
    <p>Select Color</p>
    <div class="palette">
      <div class="color purple" data-color="purple"></div>
      <div class="color green" data-color="green"></div>
      <div class="color red" data-color="red"></div>
      <div class="color blue" data-color="blue"></div>
      <div class="color orange" data-color="orange"></div>
    </div>
    <div class="palette">
      <div class="color prusia" data-color="prusia"></div>
      <div class="color yellow" data-color="yellow"></div>
      <div class="color pink" data-color="pink"></div>
      <div class="color brown" data-color="brown"></div>
      <div class="color gray" data-color="gray"></div>
    </div>
    <div class="toggle"><i class="fa fa-angle-left"></i></div>
  </div>

<jsp:include page="/WEB-INF/jsp/cmn/inc/footerResource.jsp"/> 
</body>
</html>
