<b>Test Self-Med</b>

Le but de ce test est d'implémenter les deux endpoints *"/api/output/json"* et *"/api/output/selfmed"* . <br>
Ces deux endpoints doivent retourner le xml issu du endpoint *"/api/input/xml"* formatter respectivement en json et dans un format inventé "selfmed" (cf: ci-dessous).<br>
Le but est de voir comment vous architecturez le tout (interface, enum, etc...)


* Xml input:
```xml
<root>
	<transaction id="127" date="2019-07-26">
		<label>Achat De Titres</label>
		<amount>-800,10</amount>
		<status>ASSIGNED</status>
	</transaction>
	<transaction id="124" date="2019-02-01">
		<label>CHQ 564789-l</label>
		<amount>42,22</amount>
		<status>ASSIGNED</status>
	</transaction>
	<transaction id="956" date="2019-04-25">
		<label>NETFLIX ORIGINAL</label>
		<amount>-14,00</amount>
		<status>NOTASSIGNED</status>
	</transaction>
</root>
```

* JSON output:
```json
{
	"transactions": [
		{
			"id": 127,
			"date": "26/07/2019",
			"debit": 800.10,
			"credit": 0,
			"label": "Achat De Titres",
			"status": "ASSIGNED"
		},
		{
			"id": 124,
			"date": "01/02/2019",
			"debit": 0,
			"credit": 42.22,
			"label": "CHQ 564789-l",
			"status": "ASSIGNED"
		},
		{
			"id": 956,
			"date": "25/04/2019",
			"debit": 14.00,
			"credit": 0,
			"label": "NETFLIX ORIGINAL",
			"status": "NOTASSIGNED"
		}
	]
}
```

* Selfmed output:
```
transaction:
	id: 127
	date: 2019-07-26
	amount: -80010
	label: Achat De Titres
	status: 0
transaction:
	id: 124
	date: 2019-02-01
	amount: 4222
	label: CHQ 564789-l
	status: 0
transaction:
	id: 956
	date: 2019-04-25
	debit: -1400
	label: NETFLIX ORIGINAL
	status: 1
```
