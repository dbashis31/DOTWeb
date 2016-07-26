<nav class="navbar-default navbar-static-side" role="navigation">
	<div class="sidebar-collapse">
		<ul class="nav metismenu" id="side-menu">
			<li class="nav-header">
				<div class="dropdown profile-element">
					<img src="resources/image/logo.png/">
				</div>
				<div class="logo-element">DOT</div>
			</li>

			<li><a href="layouts.html"><i class="fa fa-th-large"></i> <span
					class="nav-label">Dashboards</span></a></li>
			<li class="active"><a href="welcome"><i
					class="fa fa-database"></i> <span class="nav-label">Scan</span></a></li>
			<li><a href="#"><i class="fa fa-cogs"></i><span
					class="nav-label">Rationalization</span> <span class="fa arrow"></span></a>
				<ul class="nav nav-second-level collapse out">
					<li><a ui-sref="home.optimize"><i class="fa fa-cog"></i><span class="nav-label">Optimization</span>
							<span class="fa arrow"></span></a>
						<ul class="nav nav-third-level collapse in">
							<li><a ui-sref="home.dataType">Data Type</a></li>
							<li><a ui-sref="home.dataSize">Size</a></li>
							<li><a ui-sref="home.key">Unique Key</a></li>
							<li><a href="#">Relationship</a></li>
							<li><a ui-sref="home.index">Index</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-cog"></i><span class="nav-label">Similarity</span>
							<span class="fa arrow"></span></a>
						<ul class="nav nav-third-level collapse in">
							<li><a ui-sref="home.context">Context</a></li>
							<li><a href="graph_flot.html">Metadata</a></li>
							<li><a href="graph_flot.html">Data</a></li>
							<li><a href="graph_flot.html">Archives</a></li>
							<li><a href="graph_flot.html">Clones</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-cog"></i><span class="nav-label">Storage
								Capacity</span> <span class="fa arrow"></span></a>
						<ul class="nav nav-third-level collapse in">
							<li><a ui-sref="#">Redundant</a></li>
							<li><a href="#">Un-utilized</a></li>
							<li><a href="#">Denormalized</a></li>
							<li><a href="#">Dormant</a></li>
						</ul></li>

				</ul></li>
			<li><a href="layouts.html"><i class="fa fa-user"></i> <span
					class="nav-label">Administration</span></a></li>
			<li><a href="layouts.html"><i class="fa fa-globe"></i> <span
					class="nav-label">Services</span></a></li>
			<li><a href="layouts.html"><i class="fa fa-bar-chart-o"></i>
					<span class="nav-label">Reports</span></a></li>

		</ul>

	</div>
</nav>