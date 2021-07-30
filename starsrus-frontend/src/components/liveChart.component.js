import React, { useState, useEffect } from "react";
import ReactApexChart from "react-apexcharts";
import StockService from "../services/stock.service";


var dataFilter = (obj) => {
	var res = []
	for (let i = 0; i < obj.length - 180; i++) {
		var item = {
			x : new Date(2021, 1, 1, Math.floor(i/10)+8, i%10 * 6, 0),
			y : obj[i]
		}
		res.push(item);
		console.log(i, Math.floor(i/10));
	}

	return res;

}

const LiveChart = (props) => {

	const [data, setData] = useState();
	const [history, setHistory] = useState();

	useEffect(() => {
		async function fetchData() {
		const result = await StockService.getData();
		result.data.history = dataFilter(result.data.history);
		console.log("RESULT --- : ", result);
		setData(result);
		setHistory(result.data.history)
		// console.log(dataFetch(result.data.history));
	  }
	  fetchData();
	  
	}, []);

	const series = [{
		name: "price",
		data: history
	}];


	// const series = [{
		// name: "price",
		// data: [
		// 	{
		// 		x: new Date(2016, 1, 1, 0, 0, 0),
		// 		y: [33, 26, 37, 28]
		// 	},

		// 	{
		// 		x: new Date(2016, 1, 1, 0, 10, 0),
		// 		y: [10, 9, 1, 44]
		// 	},

		// 	{
		// 		x: new Date(2016, 1, 1, 0, 20, 0),
		// 		y: [16, 43, 22, 48]
		// 	},		
		// 	{
		// 		x: new Date(2016, 1, 1, 0, 30, 0),
		// 		y: [38, 28, 36, 14]
		// 	},
		// 	{
		// 		x: new Date(2016, 1, 1, 0, 40, 0),
		// 		y: [49, 39, 38, 48]
		// 	},
		// 	{
		// 		x: new Date(2016, 1, 1, 0, 50, 0),
		// 		y: [19, 48, 44, 41]
		// 	},
		// 	{
		// 		x: new Date(2016, 1, 1, 1, 0, 0),
		// 		y: [5, 27, 40, 37]
		// 	},				
		// ]
	// }];

	const options = {
		chart: {
			height: 350,
			type: "area"
		},

		dataLabels: {
			enabled: false
		},

		stroke: {
			curve: 'smooth'
		},

		xaxis: {
			type: 'datetime',
			categories: [
				"1/22/20",
				"2/1/20",
				"2/15/20",
				"3/1/20",
				"3/15/20",
				"4/1/20",
				"4/15/20",
				"5/1/20",
				"5/7/20",
			  ]
		},

		tooltip: {
			x: {
				format: 'dd/MM/yy'
			}
		},

	plotOptions: {
		candlestick: {
		colors: {
			upward: '#36F2FE',
			downward: '#f5427b'
		}
		}
	}
};


const options2 = {
	chart: {
		height: 350,
		type: "area"
	},

	dataLabels: {
		enabled: false
	},

	stroke: {
		curve: 'smooth'
	},

	xaxis: {
		type: 'datetime',
		categories: [
			"1/22/20",
			"2/1/20",
			"2/15/20",
			"3/1/20",
			"3/15/20",
			"4/1/20",
			"4/15/20",
			"5/1/20",
			"5/7/20",
		  ]
	},

	tooltip: {
		x: {
			format: 'dd/MM/yy'
		}
	},


	colors: ["#36F2FE","#f5427b"],

	fill: {
		type: "gradient",
		gradient: {
			shadeIntensity: 1,
			opacityFrom: 0.7,
			opacityTo: 0.9,
			stops: [0, 90, 100]
		  },
		colors: ['#36F2FE', "#f5427b"]
		},
};


 return (
	 <div style= {{
		 backgroundColor: "white",
		 textAlign: "left"
	 }}>
		 <div>Stock name: {data.data.ticker}</div>
		 <div>Price: {data.data.price}</div>
		 <div>Company: {data.data.company}</div>
		 {/* {data.map( d => <div>{d.data.ticker}</div>)}      */}
		<ReactApexChart 
			options={options}
			type="candlestick"
			series={series}
			height={350}
			// width={500}		

		/>
			<ReactApexChart 
			options={options2}
			type="area"
			series={series}
			height={350}
			// width={500}	
			color={["36F2FE"]}
		/>

	 </div>
 )

};

export default LiveChart;