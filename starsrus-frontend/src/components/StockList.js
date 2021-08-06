import React, { Component } from "react";
import { Table } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/js/src/collapse.js";

/* takes an array prop 'stocks' and returns a card with a list of the stocks in the array */

function StockList(props) {
    let header = props.header;
    let stock_list = props.stock_list;
    return (
        <div>
            <h5>{header}</h5>
            <tr data-toggle="collapse" data-target="#demo1" class="accordion-toggle">
                <td>1</td>
                <td>05 May 2013</td>
                <td>Credit Account</td>
                <td class="text-success">$150.00</td>
                <td class="text-error"></td>
                <td class="text-success">$150.00</td>
            </tr>

            <tr>
                <td colspan="6" class="hiddenRow">
                    <div class="accordion-body collapse" id="demo1">Demo1</div>
                </td>
            </tr>
        </div>
    );
}

export default StockList;