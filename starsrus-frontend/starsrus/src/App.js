import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router, Switch, Route} from "react-router-dom";


import NavigationBar from "./components/NavigationBar";
import Home from "./components/Home";
import { Container } from 'react-bootstrap';
import Admin from './components/Admin';
import AdminList from './components/AdminList';

import Customer from './components/Customer';
import CustomerList from './components/CustomerList';
import ActorStock from './components/ActorStock';
import ActorStockList from './components/ActorStockList';

function App() {
  return (
    
    <Router>
      <NavigationBar /> 
        <Container>
        <Switch>
            <Route path="/" exact component={Home} />
            <Route path="/customer" exact component={CustomerList} />
            <Route path="/add_customer" exact component={Customer} />
            <Route path="/edit/:username" exact component={Customer} />
            <Route path="/admin" exact component={AdminList} />
            <Route path="/add_admin" exact component={Admin} />
            <Route path="/edit_customer/:username" exact component={Customer} />


            <Route path="/stock" exact component={ActorStockList} />
            <Route path="/add_stock" exact component={ActorStock} />
            <Route path="/edit_stock/:symbol" exact component={ActorStock} />
            
        </Switch>
        </Container>
      </Router>
  );
}

export default App;
