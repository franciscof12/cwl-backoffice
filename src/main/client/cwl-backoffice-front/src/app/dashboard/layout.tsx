import SideNav from "@/app/dashboard/components/sideNav";
import Header from "@/app/dashboard/components/header";
 

export default function RootLayout({
                                       children,
                                   }: {
    children: React.ReactNode
}) {
    return (
            <div className="grid grid-cols-8 grid-rows-12 h-screen w-screen bg-color-ui-crema_white">
            <div className="row-span-12 p-2 h-full w-full bg-color-ui-crema_black">
                <SideNav/>
            </div>
            <div className="col-span-9 bg-transparent p-2 w-full items-center justify-center">
                <Header />
            </div>
            <div className="col-span-9 row-span-11 col-start-2 row-start-2 bg-transparent w-full h-full p-2">{children}</div>
        </div> 
    )
}