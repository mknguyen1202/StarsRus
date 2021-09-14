import React, { Table } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "react-bootstrap-table-next/dist/react-bootstrap-table2.min.css";

/* takes an array prop 'stocks' and returns a card with a list of the stocks in the array */

function StockList(props) {
    let header = props.header;
    let stock_list = props.stock_list;

    function toggle(row) {
        if (isNaN(row)) row = document.getElementById(row); // id passed
        else row = document.getElementById('table1').rows[row]; // idx passed
        if (row) row.style.display = (row.style.display == 'none') ? '' : 'none';
        return false;
    }

    return (
        <div>
            <h5>{header}</h5>
            <table class="table table-primary">
                <thead>
                    <td>Name</td>
                    <td>Graph</td>
                    <td>Quantity</td>
                </thead>
                <tr>
                    <td>Inductive Automation</td>
                    <td>__/\__</td>
                    <td>$420.69</td>
                </tr>
                <tr>
                    <td>Lucid Circuit</td>
                    <td>~-\__</td>
                    <td>$-0.69</td>
                </tr>
                <tr>
                    <td>Savioke Inc.</td>
                    <td>____|</td>
                    <td>$4.20</td>
                </tr>
            </table>
        </div>
    );
}

export default StockList;