import BoxRegisterExpense from "../../components/box_register_expense/BoxRegisterExpense";
import Menu from "../../components/menu/Menu";
import { useLocation} from 'react-router-dom';
import './Expense.css'

export default function Expense(){
    const location = useLocation();
    return(
        <> 
            <Menu/>
            <main>
                <div className='container_sections_expense'>
                    {
                        location.state.expense? 
                        <BoxRegisterExpense infEx={location.state.expense} infUser={location.state.user}/>:
                        <BoxRegisterExpense infEx={{}} infUser={location.state.user}/>
                    }
                  
                </div>
            </main>
           
        </>
    )
}