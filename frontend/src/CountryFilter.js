import React from 'react';
import _ from 'lodash';
import './CountryFilter.css';


class CountryFilter extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			error: null,
			isLoaded: false,
			countries: [],
			filterText: ''
		};
		this.updateFilter = this.updateFilter.bind(this);
	}
	
	componentDidMount() {
		fetch("http://localhost:8888/country")
			.then(response => response.json())
			.then(countries => {
				this.setState({
					isLoaded: true,
					countries: _.sortBy(countries, ['name'])
				});
			},
			error => {
				this.setState({
					isLoaded: true,
					error
				});
			});
	}
	

	render() {
		const {error, isLoaded, countries, filterText} = this.state;
		if (error) {
			return <div>Error: {error.message}</div>;
		}
		else if (!isLoaded) {
			return <div>Loading...</div>;
		}
		else {
			return (
				<div className="CountryFilter">
					<CountryFilterTextInput
						value={filterText}
						onChange={this.updateFilter}
					/>
					<CountryFilterTable
						countries={countries}
						filterText={filterText}
					/>
				</div>
			);
		}
	}
	
	updateFilter(event) {
		this.setState({filterText: event.target.value});
	}
	
}

function CountryFilterTextInput(props) {
	return (
		<div>
			<label>
				Search Countries:
				<input type="text" value={props.value} onInput={props.onChange} />
			</label>
		</div>
	);
}

function CountryFilterTable(props) {
	let matchingCountries = [];
	if (props.filterText.length === 0) {
		matchingCountries = props.countries.slice();
	}
	else {
		matchingCountries = props.countries
		                         .filter(country => country.name.toLowerCase().includes(props.filterText.toLowerCase()));
	}
	
	if (matchingCountries.length === 0) {
		return (<p>No countries matched the search string '{props.filterText}'</p>)
	}
	return (
		<div>
			{props.filterText.length === 0 ?
				<div>{matchingCountries.length} countries loaded.</div> :
			  <div>{matchingCountries.length} countries matching '{props.filterText}'.</div>
			}
			<table>
				<thead>
					<th>Name</th>
					<th>ISO 3166-1 alpha-2 code</th>
					<th>Continent</th>
					<th>Nationality</th>
					<th>Currency Code</th>
				</thead>
				<tbody>
					{matchingCountries.map(country => (
						<tr>
							<td>{country.name}</td>
							<td>{country.isoCode}</td>
							<td>{country.continent}</td>
							<td>{country.nationality}</td>
							<td>{country.currencyCode}</td>
						</tr>
					))}
				</tbody>
			</table>
		</div>
	);
	
	//
	//
	//
	// return (
	// 	<div>
	// 		<p>Will filter on {props.filterText}</p>
	// 		<table>
	// 			<thead>
	// 				<th>Name</th>
	// 				<th>ISO 3166-1 alpha-2 code</th>
	// 				<th>Continent</th>
	// 				<th>Nationality</th>
	// 				<th>Currency Code</th>
	// 			</thead>
	// 			<tbody>
	// 				{props.countries
	// 				      .filter(country => true)
	// 				      .map(country => (
	// 				      	<tr>
	// 					      </tr>
	// 				      ))}
	// 			</tbody>
	// 		</table>
	// 		<ul>
	// 			{props.countries.map(country => (
	// 				<li key={country.isoCode}>
	// 					{country.name}
	// 				</li>
	// 			))}
	// 		</ul>
	// 	</div>
	// );
}

export default CountryFilter;
