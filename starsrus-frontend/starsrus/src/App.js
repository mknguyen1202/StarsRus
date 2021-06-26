import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router, Switch, Route} from "react-router-dom";


import NavigationBar from "./components/NavigationBar";
import CustomerNavBar from "./components/CustomerNavBar";
import Home from "./components/Home";
import { Container } from 'react-bootstrap';
import Admin from './components/Admin';
import AdminList from './components/AdminList';

import Customer from './components/Customer';
import CustomerList from './components/CustomerList';
import ActorStock from './components/ActorStock';
import ActorStockList from './components/ActorStockList';
import ActorMovieList from './components/ActorMovieList';
import StockMarketList from './components/StockMarketList';
import StockMarketChangePrice from './components/StockMarketChangePrice';

import MyAccount from './components/MyAccount';
import Withdraw from './components/Withdraw';
import Deposit from './components/Deposit';
import MyStocks from './components/MyStocks';
import Login from './components/Login';


function App() {
  return (
    
    // <Router>
    //   <CustomerNavBar />
    //     <Container>
    //     <Switch>
    //         <Route path="/" exact component={Home} />
    //         <Route path="/customer" exact component={CustomerList} />
    //         <Route path="/add_customer" exact component={Customer} />
    //         <Route path="/edit_customer/:username" exact component={Customer} />

    //         <Route path="/admin" exact component={AdminList} />
    //         <Route path="/add_admin" exact component={Admin} />
    //         <Route path="/edit_admin/:username" exact component={Admin} />


    //         <Route path="/stock" exact component={ActorStockList} />
    //         <Route path="/add_stock" exact component={ActorStock} />
    //         <Route path="/edit_stock/:symbol" exact component={ActorStock} />
            
    //         <Route path="/actormovie/:symbol/:actor_name" exact component={ActorMovieList} />


    //         <Route path="/stockmarket" exact component={StockMarketList} />

    //     </Switch>
    //     </Container>
    //   </Router>


    <Router>
      <NavigationBar /> 
      <CustomerNavBar />

        <Container>
        <Switch>
            {/* <Route path="/" exact component={Login} /> */}
            {/* <Route path="/:username/" exact component={Home} /> */}





            <Route path="/customer" exact component={CustomerList} />
            <Route path="/add_customer" exact component={Customer} />
            <Route path="/edit_customer/:username" exact component={Customer} />

            <Route path="/admin" exact component={AdminList} />
            <Route path="/add_admin" exact component={Admin} />
            <Route path="/edit_admin/:username" exact component={Admin} />


            <Route path="/stock" exact component={ActorStockList} />
            <Route path="/add_stock" exact component={ActorStock} />
            <Route path="/edit_stock/:symbol" exact component={ActorStock} />


            <Route path="/myaccount" exact component={MyAccount} />
            <Route path="/withdraw" exact component={Withdraw} />
            <Route path="/deposit" exact component={Deposit} />

            <Route path="/mystocks" exact component={MyStocks} />

            <Route path="/actormovie/:symbol/:actor_name" exact component={ActorMovieList} />

            <Route path="/stockmarket" exact component={StockMarketList} />
            <Route path="/add_stockmarket/:symbol/:stocktime" exact component={StockMarketChangePrice} />




            <Route path="/:username/myaccount" exact component={MyAccount} />
            <Route path="/:username/withdraw" exact component={Withdraw} />
            <Route path="/:username/deposit" exact component={Deposit} />

            <Route path="/:username/mystocks" exact component={MyStocks} />

            <Route path="/:username/actormovie/:symbol/:actor_name" exact component={ActorMovieList} />

            <Route path="/:username/stockmarket" exact component={StockMarketList} />
            <Route path="/:username/add_stockmarket/:symbol/:stocktime" exact component={StockMarketChangePrice} />


        </Switch>
        </Container>
      </Router>
  );
}

export default App;
