
import React from "react";
import "./App.css";
import {BrowserRouter as Router,Routes,Route} from "react-router-dom"
import Gpu from "./components/gpus/Gpu";
import Home from "./components/Home";
import AddGpu from "./components/gpus/AddGpu";
import EditGpu from "./components/gpus/EditGpu";
import CompareGpu from "./components/gpus/CompareGpu"
import SignIn from "./components/SignIn/SignIn";

const App = () => {





  return (
<React.Fragment>  
  <Router>

    <Routes>
{/*     <Route exact path ="/" element={<SignIn></SignIn>}/> */}
     <Route exact path ="/" element={<Home></Home>}/> 
    <Route exact path ="/gpu/:id" element={<Gpu ></Gpu>}/>
    <Route exact path ="/addGpu" element={<AddGpu></AddGpu>}/>
    <Route exact path ="/editGpu/:id" element={<EditGpu></EditGpu>}/>
    <Route exact path ="/compare" element={<CompareGpu></CompareGpu>}/>


    
  </Routes>
  </Router>
     
  </React.Fragment>);
};

export default App;
