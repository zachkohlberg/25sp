// Populate the sidebar
//
// This is a script, and not included directly in the page, to control the total size of the book.
// The TOC contains an entry for each page, so if each page includes a copy of the TOC,
// the total size of the page becomes O(n**2).
class MDBookSidebarScrollbox extends HTMLElement {
    constructor() {
        super();
    }
    connectedCallback() {
        this.innerHTML = '<ol class="chapter"><li class="chapter-item expanded affix "><a href="course_info.html">Course Information</a></li><li class="chapter-item expanded "><a href="communication.html"><strong aria-hidden="true">1.</strong> Communication and Office Hours</a></li><li class="chapter-item expanded "><a href="meetings.html"><strong aria-hidden="true">2.</strong> Class Meetings</a></li><li class="chapter-item expanded "><a href="course_material.html"><strong aria-hidden="true">3.</strong> Course Material</a></li><li class="chapter-item expanded "><a href="assignments.html"><strong aria-hidden="true">4.</strong> Assignments</a></li><li class="chapter-item expanded "><a href="grading.html"><strong aria-hidden="true">5.</strong> Grading</a></li><li><ol class="section"><li class="chapter-item expanded "><a href="grading/labor_based_grading.html"><strong aria-hidden="true">5.1.</strong> Labor-Based Grading</a></li><li class="chapter-item expanded "><a href="grading/faq.html"><strong aria-hidden="true">5.2.</strong> FAQ</a></li></ol></li><li class="chapter-item expanded "><a href="university_resources.html"><strong aria-hidden="true">6.</strong> University Resources</a></li><li class="chapter-item expanded "><a href="ai.html"><strong aria-hidden="true">7.</strong> Academic Integrity</a></li><li><ol class="section"><li class="chapter-item expanded "><a href="ai/sharing.html"><strong aria-hidden="true">7.1.</strong> Sharing Work</a></li><li class="chapter-item expanded "><a href="ai/help.html"><strong aria-hidden="true">7.2.</strong> Asking for Help</a></li><li class="chapter-item expanded "><a href="ai/group.html"><strong aria-hidden="true">7.3.</strong> Group Assignments</a></li><li class="chapter-item expanded "><a href="ai/sources.html"><strong aria-hidden="true">7.4.</strong> Using Other Sources</a></li><li class="chapter-item expanded "><a href="ai/llm.html"><strong aria-hidden="true">7.5.</strong> Artificial Intelligence</a></li><li class="chapter-item expanded "><a href="ai/violations.html"><strong aria-hidden="true">7.6.</strong> Academic Integrity Violations</a></li></ol></li><li class="chapter-item expanded "><a href="revisions.html">Syllabus Revisions</a></li></ol>';
        // Set the current, active page, and reveal it if it's hidden
        let current_page = document.location.href.toString();
        if (current_page.endsWith("/")) {
            current_page += "index.html";
        }
        var links = Array.prototype.slice.call(this.querySelectorAll("a"));
        var l = links.length;
        for (var i = 0; i < l; ++i) {
            var link = links[i];
            var href = link.getAttribute("href");
            if (href && !href.startsWith("#") && !/^(?:[a-z+]+:)?\/\//.test(href)) {
                link.href = path_to_root + href;
            }
            // The "index" page is supposed to alias the first chapter in the book.
            if (link.href === current_page || (i === 0 && path_to_root === "" && current_page.endsWith("/index.html"))) {
                link.classList.add("active");
                var parent = link.parentElement;
                if (parent && parent.classList.contains("chapter-item")) {
                    parent.classList.add("expanded");
                }
                while (parent) {
                    if (parent.tagName === "LI" && parent.previousElementSibling) {
                        if (parent.previousElementSibling.classList.contains("chapter-item")) {
                            parent.previousElementSibling.classList.add("expanded");
                        }
                    }
                    parent = parent.parentElement;
                }
            }
        }
        // Track and set sidebar scroll position
        this.addEventListener('click', function(e) {
            if (e.target.tagName === 'A') {
                sessionStorage.setItem('sidebar-scroll', this.scrollTop);
            }
        }, { passive: true });
        var sidebarScrollTop = sessionStorage.getItem('sidebar-scroll');
        sessionStorage.removeItem('sidebar-scroll');
        if (sidebarScrollTop) {
            // preserve sidebar scroll position when navigating via links within sidebar
            this.scrollTop = sidebarScrollTop;
        } else {
            // scroll sidebar to current active section when navigating via "next/previous chapter" buttons
            var activeSection = document.querySelector('#sidebar .active');
            if (activeSection) {
                activeSection.scrollIntoView({ block: 'center' });
            }
        }
        // Toggle buttons
        var sidebarAnchorToggles = document.querySelectorAll('#sidebar a.toggle');
        function toggleSection(ev) {
            ev.currentTarget.parentElement.classList.toggle('expanded');
        }
        Array.from(sidebarAnchorToggles).forEach(function (el) {
            el.addEventListener('click', toggleSection);
        });
    }
}
window.customElements.define("mdbook-sidebar-scrollbox", MDBookSidebarScrollbox);
