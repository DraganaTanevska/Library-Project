import React from 'react';
import {Link} from 'react-router-dom';

const bookTerm = (props) => {
    return (
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.author.name+" "+props.term.author.surname}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.availableCopies}</td>
            <td scope={"col"} className={"text-right"}>
                <Link title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}
                      to={`/books/delete/${props.term.id}`}>
                    Delete
                </Link>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>
                    Edit
                </Link>
                <Link className={"btn btn-info ml-2"}
                             onClick={() => props.onMarkAsTaken(props.term.id)}
                             to={`/books/markAsTaken/${props.term.id}`}>
                Mark As Taken
            </Link>
                <Link className={"btn btn-info ml-2"}
                         onClick={() => props.onReturn(props.term.id)}
                         to={`/books/return/${props.term.id}`}>
                Add copy
            </Link>
            </td>
        </tr>
    )
}

export default bookTerm;
