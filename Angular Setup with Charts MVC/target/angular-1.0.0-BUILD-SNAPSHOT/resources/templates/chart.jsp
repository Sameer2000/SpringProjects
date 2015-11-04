<body>
	First Jsp
	<style>
		#chart {
  height: 400px;
  width: 800px;
}
	</style>
	
	<button type="button" ng-click="getSales()" >{{sales}}</button>
	
	<canvas id="doughnut" class="chart chart-pie" chart-data="data" chart-labels="labels"></canvas> 
</body>
