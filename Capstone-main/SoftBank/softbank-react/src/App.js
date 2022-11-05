import './App.css';
import '@blueprintjs/core/lib/css/blueprint.css';
import { Tabs, Tab } from "@blueprintjs/core";

function App() {
  return (
    <div className="App">
      <header className="App-header">
		<p></p>
	  <img src="https://res.cloudinary.com/crunchbase-production/image/upload/c_lpad,f_auto,q_auto:eco,dpr_1/jnkukjkcemewo43kdnic" className="App-logo" alt="logo" />
        <h1>Soft Bank - Your Smart Bank</h1>
      </header>
      <div style={{
			display: 'block', width: 300, padding: 40, fontSize:20
		}}>
			<Tabs
				animate={true}
				key={"vertical"}
				vertical={false}
				fontSize={"80"}
			>
				<Tab id="home" title="Home" panel={
					<p>Render Home Page or Login Registration site</p>
				} />
				
				<Tab id="check_bal" title="Check Balance" panel={
					<p>Render Check Balance Component</p>
				} />
				<Tab id="fund_transfer" title="Fund Transfer" panel={
					<p>Render Fund Transfer</p>
				} />
				<Tab id="openfd" title="Open New FD" panel={
					<p>Render Open New FD Component</p>
				} />
				<Tab id="event" title="Events" panel={
					<p>Render Events Transfer Component</p>
				} />
				<Tab id="cheque" title="Request Cheque Book" panel={
					<p>Render Request Cheque Book Component</p>
				} />
				<Tab id="logout" title="Log out" panel={
					<p>Render Log out Component</p>
				} />
			</Tabs>
		</div >
    
    </div>
  );
}

export default App;


